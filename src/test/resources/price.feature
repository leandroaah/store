Feature: Find prices

  Scenario Outline: A user search price using filters
    Given A request filter is filled with "<day>" "<hour>" productId and brandId
    When Request is sent to backend
    Then Endpoint price response with "<priceList>" "<startDate>" "<endDate>" and "<price>"
    Examples:
      | day | hour  | priceList | startDate           | endDate             | price |
      | 14  | 10    | 1         | 2020-06-14T00:00:00 | 2020-12-31T23:59:59 | 35.50 |
      | 14  | 16    | 2         | 2020-06-14T15:00:00 | 2020-06-14T18:30:00 | 25.45 |
      | 14  | 21    | 1         | 2020-06-14T00:00:00 | 2020-12-31T23:59:59 | 35.50 |
      | 15  | 10    | 3         | 2020-06-15T00:00:00 | 2020-06-15T11:00:00 | 30.50 |
      | 16  | 21    | 4         | 2020-06-15T16:00:00 | 2020-12-31T23:59:59 | 38.95 |