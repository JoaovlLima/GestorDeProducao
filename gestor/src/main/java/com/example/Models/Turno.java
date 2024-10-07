package com.example.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Turno {
    private int id;
    private Periodo periodo;
    private int reOperador;
    private int idMaquina;
    private Date inicioTurno;
    private Date fimTurno;

    public enum Periodo {
        MANHA,
        TARDE,
        NOITE
    }
}
