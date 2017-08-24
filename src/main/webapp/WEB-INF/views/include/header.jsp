<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Navigation -->
    <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="main">Futsal</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="cal">reservation</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="listBoard">Board</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="listTransfer">Transfer</a>
            </li>
            
            <c:if test="${empty login}">
	            <li class="nav-item">
	              <a class="nav-link" href="user/login">login</a>
	            </li>
            </c:if>
            <c:if test="${!empty login}">
	            <li class="nav-item">
	              <a class="nav-link" href="user/logout">logout</a>
	            </li>
            </c:if>
            
            </ul>
        </div>
      </div>
    </nav>
