package com.logging.LogginEntities;

import java.math.BigDecimal;

public record LogginRecord(Long id, String name, String description, LogginCodeEnum code) {
    
}
