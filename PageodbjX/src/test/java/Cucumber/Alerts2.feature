Feature: Login Functionality
@sanity
  Scenario Outline: Comparing the text 
    Given Launch the browser 
    When Entering the Text <Text1> and <Text2>
    Then Reenter the Text
    
    Examples:
    |Text1|Text2|
    |Man  |ram  | 
    |sam  |dam  |
    |pam  |kam  |

