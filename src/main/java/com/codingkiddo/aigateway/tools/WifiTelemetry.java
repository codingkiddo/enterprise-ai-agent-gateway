package com.codingkiddo.aigateway.tools;

public record WifiTelemetry(
        String deviceId,
        int rssiDbm,
        int snrDb,
        double retryPercent,
        double phyRateMbps,
        double throughputMbps,
        String band,
        String accessPoint) {
}