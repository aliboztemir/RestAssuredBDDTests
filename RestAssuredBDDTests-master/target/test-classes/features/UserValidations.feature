Feature: Validating AutoGroup User API's

  @AddUser @OnlyAdd @Smoke
  Scenario Outline: Validate AddUserAPI adds user (with scope check)
    Given a valid AddUserAPI payload with data "<email>" "<name>"
    When AddUserAPI request is sent as Post HTTP request
    Then success response is sent back with status code 200
    And email value in response is "aliboztemir@gmail.com"
    And name value in response is "ali boztemir"
    And length of id value in response must be greater than zero

    Examples: 
      | email                 | name         |
      | aliboztemir@gmail.com | ali boztemir |

  @AddUser @OnlyAdd @Smoke
  Scenario Outline: Validate AddUserAPI adds user no name
    Given a valid AddUserAPI payload with data "<email>" "<name>"
    When AddUserAPI request is sent as Post HTTP request
    Then success response is sent back with status code 200
    And email value in response is "aliboztemir@gmail.com"
    And name value in response is ""
    And length of id value in response must be greater than zero

    Examples: 
      | email                 | name |
      | aliboztemir@gmail.com |      |

  @AddUser @OnlyAdd @Smoke
  Scenario Outline: AddUserAPI required field control
    Given a valid AddUserAPI payload with data "<email>" "<name>"
    When AddUserAPI request is sent as Post HTTP request
    Then success response is sent back with status code 200

    Examples: 
      | email | name |
      |       |      |

  @AddUser @OnlyGet @Smoke
  Scenario Outline: Validate GetUserAPI retrieves user (following AddUserAPI)
    Given a valid AddUserAPI payload with data "<email>" "<name>"
    When AddUserAPI request is sent as Post HTTP request
    Given a valid GetUserAPI request
    When GetUserAPI request is sent as Get HTTP request
    Then success response is sent back with status code 200
    And email value in response is "autogroup@gmail.com"
    And name value in response is "Auto Group"
    And length of id value in response must be greater than zero

    Examples: 
      | email               | name       |
      | autogroup@gmail.com | Auto Group |

  #@AddUser @OnlyGet @Smoke
  Scenario Outline: InValidate GetUserAPI retrieves user
    Given a invalid GetUserAPI request
    When GetUserAPI request is sent as Get HTTP request
    Then fail response is sent back with status code 400

  @DeleteUser @OnlyDelete
  Scenario Outline: Validate DeleteUserAPI deletes place
    Given a valid AddUserAPI payload with data "<email>" "<name>"
    When AddUserAPI request is sent as Post HTTP request
    Given a valid DeleteUserAPI request
    When DeleteUserAPI request is sent as Delete HTTP request
    Then success response is sent back with status code 200

    Examples: 
      | email                     | name              |
      | deleteautogroup@gmail.com | Delete Auto Group |

  #@DeleteUser @OnlyDelete
  Scenario Outline: InValidate DeleteUserAPI deletes place
    Given a valid DeleteUserAPI request
    When DeleteUserAPI request is sent as Delete HTTP request
    Then success response is sent back with status code 500
