<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Header -->
    <nav class="navbar navbar-expand-lg navbar-light shadow">
        <div class="container d-flex justify-content-between align-items-center">

            <a class="navbar-brand text-success logo h1 align-self-center" href="main.do">
                예담문고
            </a>

            <button class="navbar-toggler border-0" type="button" data-bs-toggle="collapse" data-bs-target="#templatemo_main_nav" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="align-self-center collapse navbar-collapse flex-fill  d-lg-flex justify-content-lg-between" id="templatemo_main_nav">
                <div class="flex-fill">
                    <ul class="nav navbar-nav d-flex justify-content-between mx-lg-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="store.do">STORE</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="event.do">EVENT</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="about.do">THIS COMPANY</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="faqList.do">FAQ</a>
                        </li>
                    </ul>
                </div>
                
                   <c:if test="${empty id }">
                    <!-- Nav Item - User Information -->
                    
							<li class="nav-item dropdown no-arrow"><a
								class="nav-link dropdown-toggle" href="#" id="userDropdown"
								role="button" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false"> <span
									class="mr-2 d-none d-lg-inline text-gray-600 small">${name }</span>
									<img class="img-profile rounded-circle"
									src="assets/img/undraw_profile.svg">
							</a> <!-- Dropdown - User Information -->
								<div
									class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
									aria-labelledby="userDropdown">
									<a class="dropdown-item" href="#"> <i
										class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
										Profile
									</a> <a class="dropdown-item" href="#"> <i
										class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
										Settings
									</a> <a class="dropdown-item" href="#"> <i
										class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
										Activity Log
									</a>
									<div class="dropdown-divider"></div>
									<a class="dropdown-item" href="#" data-toggle="modal"
										data-target="#logoutModal"> <i
										class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
										Logout
									</a>
								</div></li>
					
						</c:if>
						<c:if test="${empty id }">
						
							<div>
							<ul><a href="loginForm.do" class="btn btn-sm btn-primary">Login</a>
						
						</ul>
						</div>
						<div class="topbar-divider d-none d-sm-block"></div>
						</c:if>
						
				
                    <a class="nav-icon position-relative text-decoration-none" href="#">
                        <span class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark">장바구니</span>
                    </a>
                </div>
            </div>

        </div>
    </nav>
    <!-- Close Header -->