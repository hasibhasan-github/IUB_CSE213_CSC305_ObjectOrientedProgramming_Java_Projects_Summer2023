# Midterm_Set_C Solved by Md Hasib Hasan

## Project Description

Create a NetBeans project named "Midterm_yourId_secNo" (e.g., "Midterm_1234567_sec5"). The project involves implementing a JavaFX application with the following components:

### MyArray Class

- A model class named `MyArray` is implemented with the following features:
  - **Fields:** A private ArrayList named `vals`.
  - **Methods:**
    - Constructors for initialization.
    - Getters, setters, and toString for managing the ArrayList.
    - A `merge` method to merge two instances of `MyArray`.

### MidExamScene.FXML

- A JavaFX FXML file named `MidExamScene.FXML` is created, including the necessary `fx:ids` and event handler methods.

### MidExamSceneController Class

- The `MidExamSceneController` class is implemented with the following functionality:

  #### 3.1 Appropriate `initialize` Method
  - The controller includes an `initialize` method.

  #### 3.2 Button Handlers for arr1 and arr2 Creation
  - A method named `instantiateArr1AndClearValListButtonOnClick()` is triggered when the "arr1 create..." button is clicked. It instantiates `MyArray` instance `arr1` and clears `valList`.
  - Another method named `instantiateArr2AndClearValListButtonOnClick()` is triggered when the "arr2 create..." button is clicked. It instantiates `MyArray` instance `arr2` and clears `valList`.

  #### 3.3 Merge Button Handler
  - A method named `mergeAndShowButtonOnClick()` is triggered when the "Merge..." button is clicked.
  - The method uses the `merge` method from the `MyArray` model class to merge `arr1` and `arr2` into `arr3`.
  - The merged arrays are displayed in a `resultTextArea` with appropriate formatting.
  - If either `arr1` or `arr2` is empty, only `arr1` and `arr2` are shown, and an error alert is generated.

  #### 3.4 Traverse Button Handler
  - A method named `traverseAndShowButtonOnClick()` is triggered when the "Traverse..." button is clicked.
  - The method traverses the selected `MyArray` instance in the selected sequence (ODD/EVEN) and displays the numbers in the label as shown in the screenshot.

## Question PDF

Include relevant question pdf to illustrate the UI and functioning of the application.

### Note:

- Marks are allocated based on specific criteria outlined in the project description.
- Make sure to adhere to the specified naming conventions for classes and methods.
- Implement all the required features for the MyArray class and the MidExamSceneController class.
- Provide appropriate error handling and alerts as specified.
- Make sure the UI components are correctly connected to the corresponding controllers.
