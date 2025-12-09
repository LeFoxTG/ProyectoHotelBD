package com.hotelBD.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvUtils {

    public static List<String[]> readCsv(String path) {
        try {
            InputStream is = CsvUtils.class.getResourceAsStream(path);

            if (is == null) {
                throw new RuntimeException("Archivo no encontrado: " + path);
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            List<String[]> rows = new ArrayList<>();
            String line;

            // Saltar el encabezado
            reader.readLine();

            while ((line = reader.readLine()) != null) {

                // Preserva campos vacíos
                String[] cols = line.split(",", -1);

                rows.add(cols);
            }

            return rows;
        } catch (Exception e) {
            throw new RuntimeException("Error leyendo CSV: " + path, e);
        }
    }
}
