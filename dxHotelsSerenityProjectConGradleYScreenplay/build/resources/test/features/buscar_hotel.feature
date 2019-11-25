# language: es

Característica: Realizar busqueda de hoteles

  Esquema del escenario: Como usuario quiero realizar una busqueda de hoteles usando todos los filtros para ver los hoteles disponibles
  y debo encontrar resultados
    Dado que el usuario esta en la pagina principal de DxHotels
    Cuando el busca un hotel usando todos los filtros
      | location   | checkIn   | checkOut   | rooms   | adults   | children   |
      | <location> | <checkIn> | <checkOut> | <rooms> | <adults> | <children> |
    Entonces el deberia ver los resultados de busqueda de <location>

    Ejemplos:
      | location | checkIn    | checkOut   | rooms | adults | children |
      | Hamburg  | 11/27/2019 | 11/30/2019 | 3     | 2      | 2        |
