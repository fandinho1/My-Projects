# language: es

Característica: Escoger un hotel de acuerdo a los criterios requeridos

  Esquema del escenario: Como usuario quiero escoger el hotel mas economico de los resultados de busqueda para ver que su precio es el correcto
    Dado que el usuario esta en la pagina principal de DxHotels
    Cuando el busca un hotel usando todos los filtros
      | location   | checkIn   | checkOut   | rooms   | adults   | children   |
      | <location> | <checkIn> | <checkOut> | <rooms> | <adults> | <children> |
    Entonces el deberia ver los resultados de busqueda de <location>
    Cuando el escoge el hotel mas economico
    Entonces el deberia ver que el precio es correcto
      | checkIn   | checkOut   |
      | <checkIn> | <checkOut> |

    Ejemplos:
      | location    | checkIn    | checkOut  | rooms | adults | children |
      | New York    | 11/30/2019 | 12/2/2019 | 3     | 2      | 1        |
      | Rome        | 11/29/2019 | 12/5/2019 | 3     | 2      | 1        |
      | Los Angeles | 12/1/2019  | 12/9/2019 | 2     | 3      | 4        |
      | Paris       | 12/1/2019  | 12/9/2019 | 1     | 4      | 3        |
