package com.codingkiddo.aigateway.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
public class AirtiesDiagnosticTools {
	
	private static final Logger log = LoggerFactory.getLogger(AirtiesDiagnosticTools.class);
	
	@Tool(
		name = "getWifiTelemetry", 
		description = """
				Retrieves current Wi-Fi telemetry for a connected device.
	            Use this tool when the user asks about current Wi-Fi
	            connectivity, RSSI, SNR, retries, PHY rate, throughput,
	            Wi-Fi band, or access point association.
				This tool is read-only.
				"""
	)
	public WifiTelemetry getWifiTelemetry(
			@ToolParam(description = """
					Unique identifier of the connected device,
                    for example device-123.
					""") 
			String deviceId) {
		log.info("TOOL EXECUTED: getWifiTelemetry deviceId={}", deviceId);
		return new WifiTelemetry(
                deviceId,
                -78,
                12,
                38.0,
                72.0,
                14.6,
                "5GHz",
                "living-room-extender"
        );

	}

}
