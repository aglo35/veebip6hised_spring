<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
    .document-table th {
        text-align: center;
    }

    .error {
        color: #ff5c33;
    }

    .form-container {
        display: none;
    }

    .form-container-add-document {
        display: none;
    }

    .log-in-form {
        border: 1px solid #cacaca;
        padding: 1rem;
        border-radius: 3px;
    }
</style>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/foundation/6.2.1/foundation.min.css">

<c:if test="${not empty sessionScope.errors}">
    <div class="alert alert-danger">
        <strong>Viga!</strong> Kontrolli, et kõik väljad oleksid täidetud.
    </div>
</c:if>

<div class="row">
    <input type="search" class="light-table-filter" data-table="order-table" placeholder="Filter">
    <table class="table document-table order-table">

        <thead>
        <tr class="text-center">
            <th>Documendi id</th>
            <th>Nimi</th>
            <th>Kirjeldus</th>
            <th>Tüüp</th>
            <th>Failinimi</th>
            <th>Subjekt</th>
            <th>Seos</th>
            <th></th>
            <th></th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${requestScope.documents}" var="document">
            <tr class="text-center">
                <td><c:out value="${document.id}"/></td>
                <td><c:out value="${document.name}"/></td>
                <td><c:out value="${document.description}"/></td>
                <td><c:out value="${document.type}"/></td>
                <td><c:out value="${document.filename}"/></td>
                <td><c:out value="${document.subject}"/></td>
                <td><c:out value="${document.relation}"/></td>
                <td><a href="edit?id=${document.id}">
                    <button class="edit-document tiny button" aria-hidden="true">Muuda</button>
                </a></td>
                <td><a type="submit" action="delete" class="delete-document tiny button" id="document-${document.id}">
                    Kustuta
                </a></td>
            </tr>
        </c:forEach>
        </tbody>

    </table>

    <td><a>
        <button class="add-document tiny button" aria-hidden="true">Lisa
        </button>
    </a></td>
</div>

<div class="row form-container-add-document">
    <div class="medium-6 medium-centered large-4 large-centered columns">

        <form:form id="addDocumentForm" action="${pageContext.request.contextPath}/documentservice/add"
                   modelAttribute="document" method="POST">
            <div class="row column log-in-form">
                <label>Nimi
                    <form:input path="name" type="text" placeholder="Name"></form:input>
                    <form:errors path="name"><p class="error">Nimi peab jääma 1 ja 30 tähemärgi vahele!</p></form:errors>

                </label>
                <label>Kirjeldus
                    <form:input path="description" type="text" placeholder="Description"></form:input>
                    <form:errors path="name"><p class="error">Kirjeldus ei tohi olla tühi!</p></form:errors>

                </label>
                <label>Dokumendi tüüp
                    <form:select path="type" id="docTypes"></form:select>
                    <form:errors path="type"><p class="error">Tüüp ei tohi olla tühi!</p></form:errors>
                </label>
                <label>Failinimi
                    <form:input path="filename" type="text" placeholder="Filename"></form:input>
                    <form:errors path="filename"><p class="error">Failinimi ei tohi olla tühi!</p></form:errors>

                </label>
                <label>Subjekt
                    <form:select path="subject" id="docSubject"></form:select>
                    <form:errors path="subject"><p class="error">Subjekt ei tohi olla tühi!</p></form:errors>

                </label>
                <label>Seos
                    <form:select path="relation" id="docSubjectType"></form:select>
                    <form:errors path="relation"><p class="error">Seos ei tohi olla tühi!</p></form:errors>
                </label>
                <p><input type="submit" class="button expanded" value="Lisa dokument"></p>
            </div>
        </form:form>

    </div>
</div>