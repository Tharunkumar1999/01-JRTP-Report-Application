<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Report Form</title>
    <!-- Add Bootstrap CSS for styling -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h3 class="pb-3 pt-3">Report Application</h3>
         <form:form method="POST" action="search" modelAttribute="search">
        <table>
            <tr>
                <td>Plan Name:</td>
                <td>
                    <form:select path="planName">
                        <form:option value="">-select-</form:option>
                        <form:options items="${names}"/>
                    </form:select>
                </td>
                <td>Plan Status:</td>
                <td>
                    <form:select path="planStatus">
                        <form:option value="">-select-</form:option>
                        <form:options items="${status}"/>
                    </form:select>
                </td>
                <td>Gender:</td>
                <td>
                    <form:select path="gender">
                        <form:option value="">-select-</form:option>
                        <form:option value="Male">Male</form:option>
                        <form:option value="Fe-Male">Fe-Male</form:option>
                    </form:select> </td>
                </tr>
                <tr>
                    <td>Start Date:</td>
                    <td><form:input path="planStartDate" type="date"/></td>
                    <td>End Date:</td>
                    <td><form:input path="planEndDate" type="date"/></td>
                </tr>
                <tr>
                    <td>
                    <button type="submit" value="Search"class="btn btn-primary">Submit</button>
                    </td>
                </tr>
            
        </table>
    </form:form>

    <hr/>
        <table class="table table-stripped">
            <tr>
            <th>Id</th>
            <th>Holder Name</th>
            <th>Plan Name</th>
            <th>Plan Status</th>
            <th>Start Date</th>
            <th>End Date</th>
            </tr>
        </table>
    <hr/>

   <td> Export : <a href="">Excel </a><a href=""> Pdf</a> </td>

    </div>

   
    
    <!-- Add Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
