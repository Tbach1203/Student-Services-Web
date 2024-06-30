<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/gh/TrungHauad02/DichVuSinhVien@master/src/main/webapp/css/sb-admin-2.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="https://cdn.jsdelivr.net/gh/TrungHauad02/DichVuSinhVien@master/src/main/webapp/css/styles.css" type="text/css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/gh/TrungHauad02/DichVuSinhVien@master/src/main/webapp/css/sb-admin-2.min.css" type="text/css" rel="stylesheet">
	<style>
	
	.table-container {
		  height: 100%;
		}
    .scrollable-table {
   		min-height: 300px;
        max-height: 400px;
        overflow-y: auto;
        display: flex;
        flex-direction: column;
    }

    .scrollable-table thead,
    .scrollable-table tbody,
    .scrollable-table tr,
    .scrollable-table th,
    .scrollable-table td {
        display: flex;
        flex-direction: row;
        width: 100%;
        box-sizing: border-box;
    }

    .scrollable-table th,
    .scrollable-table td {
        text-align: left; 
        padding: 8px;
        border-bottom: 1px solid #ddd;
    }

    .scrollable-table thead {
        position: sticky;
        top: 0;
        background-color: #f2f2f2;
        z-index: 1;
    }
    .scrollable-table tbody {
	    flex-direction: column; 
	    align-items: stretch;
	}
	.common-btn {
    	width: 100%;
	}
</style>