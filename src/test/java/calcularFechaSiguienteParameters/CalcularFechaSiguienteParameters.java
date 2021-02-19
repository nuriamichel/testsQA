package calcularFechaSiguienteParameters;


import ejercicio2.CalcularFechaSiguiente;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

@RunWith(value = Parameterized.class)
public class CalcularFechaSiguienteParameters {
    private int dia;
    private String mes;
    private int anio;
    private int hora;
    private int minuto;
    private int segundo;
    private String expectedResult;

    public CalcularFechaSiguienteParameters(int dia, String mes, int anio, int hora, int minuto, int segundo, String expectedResult) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getData() {
        List<Object[]> objects = new ArrayList<>();

        objects.add(new Object[]{12, "Enero", 2021, 0, 0, 0, "12 Enero 2021 0:0:1"});
        objects.add(new Object[]{12, "Febrero", 2021, 0, 0, 59, "12 Febrero 2021 0:1:0"});
        objects.add(new Object[]{14, "Marzo", 2021, 0, 59, 59, "14 Marzo 2021 1:0:0"});
        objects.add(new Object[]{14, "Abril", 2021, 23, 59, 59, "15 Abril 2021 0:0:0"});
        objects.add(new Object[]{31, "Mayo", 2021, 23, 59, 59, "1 Junio 2021 0:0:0"});
        objects.add(new Object[]{31, "Diciembre", 2021, 23, 59, 59, "1 Enero 2022 0:0:0"});
        objects.add(new Object[]{28, "Febrero", 2020, 23, 59, 59, "29 Febrero 2020 0:0:0"});
        objects.add(new Object[]{28, "Febrero", 2019, 23, 59, 59, "1 Marzo 2019 0:0:0"});
        objects.add(new Object[]{29, "Febrero", 2020, 23, 59, 59, "1 Marzo 2020 0:0:0"});
        objects.add(new Object[]{28, "Marzo", 2019, 23, 59, 59, "29 Marzo 2019 0:0:0"});


        objects.add(new Object[]{40, "Enero", 2021, 0, 0, 0, "Dia no valido"});
        objects.add(new Object[]{-40, "Febrero", 2021, 0, 0, 0, "Dia no valido"});
        objects.add(new Object[]{29, "Febrero", 2021, 0, 0, 0, "Dia no valido"});
        objects.add(new Object[]{12, "FebreroAbril", 2021, 0, 0, 0, "Mes no valido"});
        objects.add(new Object[]{12, "Marzo", -2021, 0, 0, 0, "Anio no valido"});
        objects.add(new Object[]{12, "Abril", 2021, -12, 0, 0, "Hora no valida"});
        objects.add(new Object[]{12, "Mayo", 2021, 30, 0, 0, "Hora no valida"});
        objects.add(new Object[]{12, "Junio", 2021, 0, -100, 0, "Minuto no valido"});
        objects.add(new Object[]{12, "Julio", 2021, 0, 80, 0, "Minuto no valido"});
        objects.add(new Object[]{12, "Agosto", 2021, 0, 0, -59, "Segundo no valido"});
        objects.add(new Object[]{12, "Septiembre", 2021, 0, 0, 90, "Segundo no valido"});

        return objects;
    }

    @Test
    public void verify_fecha_all_values() {
        CalcularFechaSiguiente calcularFechaSiguiente = new CalcularFechaSiguiente();
        String actualResult = calcularFechaSiguiente.fechaSiguiente(this.dia, this.mes, this.anio, this.hora, this.minuto, this.segundo);
        Assert.assertEquals("ERROR! ", this.expectedResult, actualResult);
    }
}

