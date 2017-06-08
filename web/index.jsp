<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Questionary</title>
  </head>
  <body>

  <form action="/questionary" method="POST">
      <label for="name"> First Name: </label>
      <input type="text" id="name" name="first_name" /><br />
      <label for="surname"> Last Name: </label>
      <input type="text" id="surname" name="last_name" /><br />
      <label for="age"> Age: </label>
      <input type="number" id="age" name="age" min="0" max="140"/><br/>
    <fieldset>
      <legend>Choose the number</legend>
      <input type="radio" id="10" name="question_1" value="10"/><label for="10">10</label>
      <input type="radio" id="50" name="question_1" value="50"/><label for="50">50</label>
      <input type="radio" id="100" name="question_1" value="100"/><label for="100">100</label>
    </fieldset>

    <fieldset>
      <legend>Choose the letter(s)</legend>
      <input type="checkbox" id="A" name="question_2" value="A"/><label for="A">A</label>
      <input type="checkbox" id="B" name="question_2" value="B"/><label for="B">B</label>
      <input type="checkbox" id="C" name="question_2" value="C"/><label for="C">C</label>
    </fieldset>

    <fieldset>
      <legend>Choose the operator</legend>
      <select name="question_3" style="width: 50px">
        <option></option>
        <option value="=">=</option>
        <option value='<'>&lt;</option>
        <option value='>'>&gt;</option>
      </select>
    </fieldset>

    <input type="submit" value="Submit"/>
  </form>

  </body>
</html>
