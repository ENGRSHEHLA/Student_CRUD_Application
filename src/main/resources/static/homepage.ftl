<!DOCTYPE html>
<html>
<head>
    <title>Student Form</title>
</head>
<body>

<table border="1" cellspacing="0" cellpadding="1">
    <tr class="tableHeader">
        <th>Student Id</th>
        <th>Student Name</th>
        <th>Student Email</th>
        <th>Student Age</th>
        <th>Action</th>
       
    </tr>
        <#list students as student>
        <tr class="tableBody">
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.email}</td>
             <td>${student.age}</td>
             
             <td>
                    <a href="edit/${student.id}">Edit</a>
                    <a href="delete/${student.id}">Delete</a>
                </td>
           
        </tr>
    </#list>                             
</table>


<h1><a href="form">Add Student</a></h1>

</body>
</html>
