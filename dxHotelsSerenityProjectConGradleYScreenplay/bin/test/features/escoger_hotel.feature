# language: es

Característica: Escoger un hotel de acuerdo a los criterios requeridos

  Esquema del escenario: Como usuario quiero escoger el hotel mas economico de los resultados de busqueda para ver
    que su precio es el correcto
    Dado que el usuario esta en la pagina principal de DxHotels
    Cuando el busca un hotel
      | location   | checkIn   | checkOut   | rooms   | adults   | children   |
      | <location> | <checkIn> | <checkOut> | <rooms> | <adults> | <children> |
    Entonces el deberia ver los resultados de busqueda
    Cuando el escoge el hotel mas economico
    Entonces el deberia ver que el precio es correcto

    Ejemplos:
      | location    | checkIn    | checkOut   | rooms | adults | children |
      | Los Angeles | 11/29/2019 | 11/30/2019 | 3     | 2      | 1        |
