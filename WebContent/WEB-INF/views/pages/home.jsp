<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h2>Student Information</h2>
<form:form method="POST" action="/ROOT/ajax" commandName="bo" enctype="multipart/form-data" id="form">
   <table>
    <tr>
        <td><form:label path="name">Name</form:label></td>
        <td><form:input path="name" htmlEscape="true" alt="required" autocomplete="true"/></td>
        
    </tr>
    <tr>
        <td><form:label path="address">Address</form:label></td>
        <td><textarea rows="10" name="address" ></textarea></td>
    </tr>
    <tr>
        <td><form:label path="id">id</form:label></td>
        <td><form:input path="id" /></td>
    </tr>
    <tr>
        <td><form:label path="date">date</form:label></td>
        <td><input type="datetime-local"  name="date" /></td>
    </tr>
    <tr>
        <td colspan="2">
           <input type="file" name="file"/>
            <input type="submit" value="Submit" id ="save"/>
        </td>
    </tr>
</table>  
</form:form>
<table>
  <tr>
    <th>Column 1 Heading</th>
    <th>Column 2 Heading</th>
  </tr>
  <tr>
    <td>Row 1: Col 1</td>
    <td>Row 1: Col 2</td>
  </tr>
</table>
<p id="pop"></p>
<p id="pp"></p>
${home}

