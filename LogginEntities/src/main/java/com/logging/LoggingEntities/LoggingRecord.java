package com.logging.LoggingEntities;

import java.math.BigDecimal;

public record LoggingRecord(Long id, String name, String description, LoggingCodeEnum code) {
    
}
