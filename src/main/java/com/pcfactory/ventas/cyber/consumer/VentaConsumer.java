package com.pcfactory.ventas.cyber.consumer;

import com.pcfactory.ventas.cyber.model.Venta;
import com.pcfactory.ventas.cyber.repository.VentaRepository;
import com.pcfactory.ventas.cyber.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class VentaConsumer {

    @Autowired
    private VentaService ventaService;

    @KafkaListener(topics = "ventas", groupId = "mi-grupo-educativo")
    public void listen(
            @Payload Venta venta,
            @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
            @Header(KafkaHeaders.OFFSET) long offset,
            @Header(value = KafkaHeaders.RECEIVED_KEY, required = false) String key) {

        // aplicando la regla de negocio del requerimiento
        ventaService.registrarVenta(venta);
    }
}
