<!-- edit-student.ftl -->
<form action="/updateStudent" method="post">
    <input type="hidden" name="id" value="${student.id}" />
    First name: <input type="text" name="name" value="${student.name}" /><br/>
    Last name: <input type="text" name="email" value="${student.email}" /><br/>
    Age: <input type="number" name="age" value="${student.age}" /><br/>
    <input type="submit" value="Update">
</form>
