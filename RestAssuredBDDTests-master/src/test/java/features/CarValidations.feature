Feature: Validating AutoGroup Car API's

  Background: 
    Given a valid AddUserAPI payload with data "aliboztemir@gmail.com" "ali boztemir"
    When AddUserAPI request is sent as Post HTTP request
    Then success response is sent back with status code 200

  @AddUser @AddCar @OnlyAdd @Smoke
  Scenario Outline: Validate AddCarAPI adds car (with scope check)
    Given a valid AddCarAPI payload with data "<manufacture>" "<model>" "<imageUrl>"
    When AddCarAPI request is sent as Post HTTP request
    Then success response is sent back with status code 200
    And manufacture value in response is "Audi"
    And model value in response is "A7 Sportback"
    And imageUrl value in response is "DemoURL"
    And length of id value in response must be greater than zero

    Examples: 
      | manufacture | model        | imageUrl |
      | Audi        | A7 Sportback | DemoURL  |

  @AddUser @AddCar @OnlyAdd @Smoke
  Scenario Outline: Validate AddCarAPI adds Multiple car (with scope check)
    Given a valid AddCarAPI payload with data "<manufacture>" "<model>" "<imageUrl>"
    When AddCarAPI request is sent as Post HTTP request
    Then success response is sent back with status code 200

    Examples: 
      | manufacture | model      | imageUrl |
      | Volkswagen  | Golf       | DemoURL1 |
      | Opel        | Opel Corsa | DemoURL2 |
      | Mercedes    | e200       | DemoURL3 |

  @AddUser @AddCar @OnlyAdd @Smoke
  Scenario Outline: AddCarAPI required field control
    Given a valid AddCarAPI payload with data "<manufacture>" "<model>" "<imageUrl>"
    When AddCarAPI request is sent as Post HTTP request
    Then success response is sent back with status code 200

    Examples: 
      | manufacture | model | imageUrl |
      |             |       | DemoURL  |

  @AddUser @AddCar @OnlyAdd @Smoke
  Scenario Outline: InValidate AddCarAPI retrieves user (Invalid UserId)
    Given a invalid AddCarAPI payload with data "<manufacture>" "<model>" "<imageUrl>"
    When AddCarAPI request is sent as Post HTTP request
    Then fail response is sent back with status code 400

    Examples: 
      | manufacture | model        | imageUrl |
      | Audi        | A3 Sportback | DemoURL  |

  @AddUser @AddCar @OnlyAdd @Smoke @OnlyGet
  Scenario Outline: Validate GetCarAPI retrieves user (following AddCarAPI)
    Given a valid AddCarAPI payload with data "<manufacture>" "<model>" "<imageUrl>"
    When AddCarAPI request is sent as Post HTTP request
    Given a valid GetCarAPI request
    When GetCarAPI request is sent as Get HTTP request
    Then success response is sent back with status code 200
    And manufacture value in response is "BMW"
    And model value in response is "BMW 1"
    And imageUrl value in response is "DemoURL"
    And length of id value in response must be greater than zero

    Examples: 
      | manufacture | model | imageUrl |
      | BMW         | BMW 1 | DemoURL  |

  #@AddUser @AddCar @OnlyAdd @Smoke @OnlyGet
  Scenario Outline: InValidate GetCarAPI retrieves user (Invalid CarId)
    Given a valid AddCarAPI payload with data "<manufacture>" "<model>" "<imageUrl>"
    When AddCarAPI request is sent as Post HTTP request
    Given a invalid GetCarAPI request
    When GetCarAPI request is sent as Get HTTP request
    Then success response is sent back with status code 400

    Examples: 
      | manufacture | model | imageUrl |
      | BMW         | BMW 1 | DemoURL  |

  @AddUser @AddCar @OnlyAdd @Smoke
  Scenario Outline: Validate PutCarAPI adds car (with scope check)
    Given a valid AddCarAPI payload with data "<Audi>" "<A7 Sportback>" "<DemoURL>"
    When AddCarAPI request is sent as Post HTTP request
    Then success response is sent back with status code 200
    Given a valid PutCarAPI payload with data "<manufacture>" "<model>" "<imageUrl>"
    When PutCarAPI request is sent as Put HTTP request
    Then success response is sent back with status code 200
    Given a valid GetCarAPI request
    When GetCarAPI request is sent as Get HTTP request
    And manufacture value in response is "Updated Manifacture"
    And model value in response is "Updated Model"
    And imageUrl value in response is "Updated"
    And length of id value in response must be greater than zero

    Examples: 
      | manufacture         | model         | imageUrl |
      | Updated Manifacture | Updated Model | Updated  |

  @AddUser @AddCar @OnlyAdd @Smoke
  Scenario Outline: PutCarAPI required field control
    Given a valid AddCarAPI payload with data "<Audi>" "<A7 Sportback>" "<DemoURL>"
    When AddCarAPI request is sent as Post HTTP request
    Then success response is sent back with status code 200
    Given a valid PutCarAPI payload with data "<manufacture>" "<model>" "<imageUrl>"
    When PutCarAPI request is sent as Put HTTP request
    Then success response is sent back with status code 400

    Examples: 
      | manufacture | model | imageUrl |
      |             |       | Updated  |

      
      
#@AddUser @AddCar @OnlyAdd @Smoke
  Scenario Outline: InValidate PutCarAPI retrieves car (Invalid CarId)
    Given a valid AddCarAPI payload with data "<Audi>" "<A7 Sportback>" "<DemoURL>"
    When AddCarAPI request is sent as Post HTTP request
    Then success response is sent back with status code 200
    Given a invalid PutCarAPI payload with data "<manufacture>" "<model>" "<imageUrl>"
    When PutCarAPI request is sent as Put HTTP request
    Then success response is sent back with status code 400
      
      
@AddUser @AddCar @OnlyAdd @Smoke
  Scenario Outline: Validate DeleteCarAPI adds car (with scope check)
    Given a valid AddCarAPI payload with data "<Audi>" "<A7 Sportback>" "<DemoURL>"
    When AddCarAPI request is sent as Post HTTP request
    Then success response is sent back with status code 200
    Given a valid DeleteCarAPI request
    When DeleteCarAPI request is sent as Delete HTTP request
    Then success response is sent back with status code 200
    
    
#@AddUser @AddCar @OnlyAdd @Smoke
  Scenario Outline: Validate DeleteCarAPI adds car (with scope check)
    Given a valid AddCarAPI payload with data "<Audi>" "<A7 Sportback>" "<DemoURL>"
    When AddCarAPI request is sent as Post HTTP request
    Then success response is sent back with status code 200
    Given a invalid DeleteCarAPI request
    When DeleteCarAPI request is sent as Delete HTTP request
    Then success response is sent back with status code 400
