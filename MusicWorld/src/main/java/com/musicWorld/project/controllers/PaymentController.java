package com.musicWorld.project.controllers;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.musicWorld.project.entities.Users;
import com.musicWorld.project.services.UsersService;
import com.razorpay.*;

import jakarta.servlet.http.HttpSession;

@Controller
public class PaymentController {
	@Autowired
	UsersService uService;
	
	@PostMapping("/create-order")
	@ResponseBody
	public String createOrder() {
		Order order = null;
		
		try {
			RazorpayClient razorpay = new RazorpayClient(
					"rzp_test_fOZMBRxyWNBVhm", "qCUaSgpnMSNOapgNsKzTJBIN");
	
			JSONObject orderRequest = new JSONObject();
			orderRequest.put("amount",50000);
			orderRequest.put("currency","INR");
			orderRequest.put("receipt", "receipt#1");
			JSONObject notes = new JSONObject();
			notes.put("notes_key_1","Tea, Earl Grey, Hot");
			orderRequest.put("notes",notes);
			order = razorpay.orders.create(orderRequest);
		} catch (RazorpayException e) {
			e.printStackTrace();
		}
		
		return order.toString();
	}
	
	@PostMapping("/verify-payment")
	@ResponseBody
	public boolean verifyPayment(@RequestParam String orderId, 
															@RequestParam String paymentId, 
															@RequestParam String signature) {
		
		try {
			RazorpayClient razorpay = new RazorpayClient(
					"rzp_test_fOZMBRxyWNBVhm", "qCUaSgpnMSNOapgNsKzTJBIN"
					);
			
			String verificationData = orderId +" | "+ paymentId;
			
			boolean isValidSignature =  Utils.verifySignature(verificationData, signature, "qCUaSgpnMSNOapgNsKzTJBIN");			
		
			return isValidSignature;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@GetMapping("/payment-success")
	public String paymentSuccess(HttpSession session) {
		String email = (String) session.getAttribute("email");
		
		Users user = uService.getUserByEmail(email);
		user.setPremium(true);
		uService.updateUser(user);
		
		return "login";
	}
	
	@GetMapping("/payment-failure")
	public String paymentFailure(String email) {
		
		return "paymentFailure";
	}
	
}
