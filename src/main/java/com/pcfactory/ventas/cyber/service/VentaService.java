package com.pcfactory.ventas.cyber.service;

import com.pcfactory.ventas.cyber.model.Venta;
import com.pcfactory.ventas.cyber.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public Venta registrarVenta(Venta venta) {

        ventaRepository.save(venta);
        return venta;
    }
}
