package com.codingkiddo.aigateway.api;

import org.springframework.ai.chat.client.ChatClient;
//import org.springframework.ai.chat.model.ChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingkiddo.aigateway.tools.AirtiesDiagnosticTools;

@RestController
@RequestMapping("/api/ai")
public class AiController {

//	private final ChatModel chatModel;
	private ChatClient chatClient;
	private AirtiesDiagnosticTools airtiesDiagnosticTools;

	public AiController(ChatClient.Builder chatClientBuilder, AirtiesDiagnosticTools airtiesDiagnosticTools) {
		this.airtiesDiagnosticTools = airtiesDiagnosticTools;

		this.chatClient = chatClientBuilder.defaultSystem("""
				You are a defensive ISP Wi-Fi
				                diagnostics assistant.

				                Never invent device telemetry.

				                When the user asks about current
				                device telemetry, use an available
				                telemetry tool.

				                Base conclusions on retrieved evidence.

				                Clearly distinguish facts from hypotheses.

				""").build();
	}

	@GetMapping("/ask")
	public String ask(@RequestParam String message) {
		String response = chatClient.prompt().user(message).tools(airtiesDiagnosticTools).call().content();
		return response;
	}
}