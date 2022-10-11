<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Basic Struts 2 Application - Welcome</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
  </head>
  <body>
    <s:include value="../navbar.jsp"/>
    <div class="mx-5">
      <table class="table bg-light">
        <thead>
          <tr>
            <th scope="col">Cover</th>
            <th scope="col">Title</th>
            <th scope="col">Chapters</th>
          </tr>
        </thead>
        <tbody>
          <s:iterator value="response.data">
          <tr>
            <th>
              <s:iterator value="relationships" >
              <s:if test="type=='cover_art'" >
                <s:property value="id" />
              </s:if>
              </s:iterator>
            </th>
            <td><s:property value="id" /></td>
            <td><s:property value="attributes.title.en" /></td>
          </tr>
          </s:iterator>
        </tbody>
      </table>
    </div>
  </body>
</html>
