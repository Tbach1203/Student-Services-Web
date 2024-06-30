<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Quên mật khẩu</title>

    <!-- Custom fonts for this template-->
    
     <jsp:include page="./head.jsp" />
</head>
<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
			<!-- Sidebar - Brand -->
	        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.jsp">
	            <div >
	                <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAABJlBMVEX///8vVajtGyT///38//+yvdkcS6EpUacvVacvVaorUqeisdDqAAD//v8IQ57z9fZad7Fuhr8cSqSaqspNbawzXKi7xtoRSaGNnciImsG3wdrnAADh5u7sAAtDZq75///tEh1sh7vG0N/tCxnq7fJ0i7o6X6vb4uyBlsD///geT6DwAADtamnvgoXR2uVogrdPbbH57vD30dHypaZZdrbww8DrLzHysbPz2dXpOT7qXmP88/H35ePsiIjrVljrQ0kANprumpnqio3sdXTrMjnreHzzt7npWFXpJSjvrKj4pqGna4zHr8PRFDU2XaJoQINsU46+HkWiJ1dPVZaxJE+WMGY7R5ZOP4v2ztTutLDubHPumJ7yh47ddH3jipfrb2rsTFb6xr7cWl4tAAAdOklEQVR4nO1dB3/iSJYvVIUkRBAWOQgEEgZjEwwmGQxjDG48d+cLe6HdM3vj/f5f4l4pAwJ7pxvs3uPtb6fdboX618uvXpUQOtGJTnSiE53oRCc60YlOdKITnehEJzrRiU50ohMdlzDCQPQH+gf+6OEcgjAOY1zEBABe/AMB1Lkm5svBTCXaPj8/TwCdF9rRStpf1kR6wUeP8HsJ55O1eCFeyvjL1bwmGqTlqwC51H6OZsraR4/wu6hYriQSlWxV9P7nsNj0l3yJdBn/nIwUkzf1s6yIkWv8ZLx+DbU4eT9cVyZHHt13EtgS4F6pvME7It4NPa8Xk61ErYp+FlbCOIm/0E6KW1aETO93sApjzV+IJ38Su4OL6Xql6jXU4eVyjzBelKO8/9O7EeCfmOYymrfAXTO5u/DuexHKV3h/8ZMLa9ifSO+0/2Quy1e7IVKQ1cp58hMDxKh53trj30h4pcjT/U9A1Xa8+qMH9sNILJ0399uKgcxcvux/CMbZevpTshGjZD22f2RFci8zagM9vfEosfbWTH0EYVxpV/cOK4zwg8ww6n33FQR2P4ByIvbpIOYTmTdsYJjcXzKA8Fd1CbHN/hgGi6X4jlDvgwh0p7zfXY/HaLxQACFzpU5Rr/vmI/3wxE/ExnT7rRRhvBheg4wyfWWlqOTu8a0ngl1OBD8NwotW6+3A+XU2oVr4sJSZ0OTqbR6CwYlnvn9sP4TEeO0dYcit0qEI78KMoj7ID+95ML4pfffgfgSJz8H3XDZTHwGhPEBP4DGU1b7QxqFa9OK7xvYjCIsJP37HcMd9da4CDydkvAKDE+q97+np+IdHqRTgOy4jwxXTZxjlilyQL4BQmb4z5c1EPxih+Ox/l00n8zvgICP3SPh6RX1GyDsX3qb0x0LE8XfpILj7Kagfo4xgtI8hihCCt3e+olL508P7fsKlzUBm13x3bnVLukRN8Z66RUbpj3dp78YTcTT2cbqYjkIIWYjb1I7nd1w5byBqZ+5QrPSrjhBszS5NbLqeGG9XMXnOHgrAG4STz5CycpxgUaq9M5Z8aBBQRGWKbhL/ZCCU57sQ4mpCsp/JJTQs1psfwUSM8nweaeeCzyReau0ex3I27NC4+59rrcy/KIYi7kSItDhrPdXHRYuo/PwRYTjG50mEopw9FKmyxy12L3NDqoj/qiWK/6YjlHfV3SiJUQciW0E41vqIKLxWA2/FugDuu3giy+DwlX/PoHjR/x+gkoo62Xe9CyIfAYd08y6v+2OpnICsXnIA7g8hyVweAd/+ouGbPIkrNATf/3jStqUjwFaRyO6yYYciCNaa8H97FGzrrRumMqP8B3jPsyYK/qeirMZv3CA6Gi60Mc7eHNtl1DLgDVneMge7rahJRPwSYs5hlLUyyv/rpTx8o46BwJDZENkYQi3/jxr6uwgMehhlI7aqJN6xRkbu/8uPwigG9um/v+xVQvMdTXsCfZEm0uraEZmIL9plJNadAZR3XIfD5qjgD4L0WipFWMDviLsx8kesNwgFuPGo0VsWgpka6wiR9+wSSuZPAFCM0r9QhHFaWbyedDq9Xq8znOzkTYkNWIYsiHDieJViTBJ5XLXeznNRvGEFDM51BnfT0YpRFKY/mi7vH4c3F8AYijDx0pgxcgh+P1qs5Jw6ajxeUyavcxZD5mKpopAQUTJ6NKeIgxV80bJfzm8bcjLpTnOr6d1L7+twOARevdw/zPp/ITDENMj3/0znvc6YIqI8xsPe3Sw3e/KwruWUxUQ2jVG8fCyEIrCwLFk6Ut9IoGDYvdvc7dOW8OEWXZOqNVEybf0qHLbYMhlM5fk12eRi2lYFIY/KR6tp+EHnoxYLufjmOmhnpt5PSHF7vpMxQHiWR3EPy0uKZHgV2orkxIT1HraGL+LNHwdiD2EEYllOWY4ita7/ZHyV6+5a6YVUCMVxsrbjyWQ4Wkw2lDFpyUogpR1LEzF9z43A21O79tKOstwdrRSjZa3Q3FlcBfm+D63XijGOW3ETl0FhUI/vHv87KF5GVYuFgfqGxHUUcbevy7bYdqIeTe+8AFQ4txEMNJ1XiTi4i/0/lPIJ8IWCM7HrVJS9c3c9s4pJvMDz9bYha57s6I02rU3LFpcgKtaPkShmgkhLWL6QXw+lwgN55lknNFr2gnouIuypnpFpf7iBsGlpIl8gqHKEggY+15Dfkhx2Q2omuUeibtcJsVYRMS6fCfrEBIQSOLZwTdvOFsiQ6SrrBhXbWXYgVQaHcfgUowl2xs7sU2vOnqBJf44ajeImF/PnUqsaTQmW++ZSrXxLKmyF0oQ0lsXGw8btdhYK84kLh++Dq2VR3mRhQNiY0a+hpYqHua1qRjISEFjOx9dNgALPcRwf2V49C+eGxdyis5FZJXjeDt3S7yzQ/nmiQhqULLFJrv8b7g+/zdHr9jq9nwWVTbUzOu+5UpzmRXxw29YMZqR7+5Rb8zcYx6w0CsQUROjAVI274pnEJrcGs6Eqviw2b8Iiy/OQgTQlwyZexFhfwCunHD0WV19/X27EQ5bM+LgapP6HtaaQGsSQGDH1id1awQz3O7ddkutsKmILZDILZjGicx6ydX+K57brZ8MceVxc5yYbt+OoFZvykFElDxrXhFG7ibKW5ktbiS957A9XZP5tY4iAjBYicBUQBgIStfgZCRL3jaEWH+7IqNdYbr3Wtt2RKsrWDmpMMamDTzItKX8ubpv7xeN0cJ27Xv9tiePbRROhL8BS7cUJXtgsz13Lk05/ssVCEFMrF4VEOH9+WH9BFd1KS7mKx6seR4/94u3aMj3WEkKKlmiQFjHtBVBQCvAbKvU0JdOnxpJsIsS4bb3yDCzrYRUxGMN5n6WGa9Uvgq7vHzqk2B/Mer2FyyViVJUCdeo4saHBkp4DaVKAbSJXdYCAhE6UDrBw+ADZ1xrMmik2QgLj1o6i0A+iMwgrzKQ0UHfnTeHebUiWV9fo62gwIn0nOBVvKlFOaFOri8M6QiNMEAuCcJapOQwhnVXx232jQcSFLIemj2477X5nMHZQhM8aiplvE54tFIQM5/2QyjDyCAY8Gyw63VsbYZ4TOJ/Qpj9ipBfPItRNYEjAfJz0i0vkvs2v5a8qcG9KF1MvV3dDO1fM1y25gRk+OyRAkZprU2I46nvDNOd9maqywijy5dUEPFmv3526bE0+IjkIUxRhSt9mAbrFS26E49z1fDlfQrI/+SMEz2NkearXbmhdq2AqIphkLXFIhNU2xlErmaE9ksC+JYXHqKHR/biIhyIhr11m+O3enpRmOcYKBQMJLbEGBB2hmBDYWDLpqFv3VlS/QnZ4Ac8Yd0eXdPlGVh+Guka2rGmtHNbU4HIJi+eWN0yi8Lg7o9KpyiswMmTYYELyEHWY326HistUgLFnDZ1NUITGCKuRgHu1hZDV1+635ZJMlJDSGNKH9WVVn7numNgVKeEGo/YBF2mwP400zlSJSBOR2SWVptB0MIZpf9VVEZg3nfcnC6cagcGocGk9EqGrLYIRd2Uk4dn97J5CFgN5Qp5CFNbs/hqk/0uIamQItNuKMqgwnB2wHoUhsq+a7+JTGppcKmpInU9IsXelUFll1FwHoc6qsRy4E+E0FxD0VImqk1Cgm0w0ll+rD5Dbbm+6fKApJm1Lgafd9opocq+EVCX0FTXNNZIAr6FMcnNcP5AqSVS2EUKEc7e67REyuVNDxrCYK5qhk9uGMnEnwhob0O0SoouCQhvTlrU6TJErYpjkxMW9Qu3T5IHRJwuw3YG09q5WEInnrVUgkOzYIRMo8LZWjMjz9BdFNB58yem9ByqYvmsymYCzH/a/3f1+59JEUCOJRkA0K+GiYYwrEAS4/BomEC0slo1isTiZkPFgqqq6RIRmoITEjhWoIa4i/yHbwKPgcE2d5wu07bf3zZhwNcSA+yo+TtXQFUHk28OqpzgLTFjkIHu6qaIzirCFqjcsT2M2J54JM8Pb35kJCTcu5S+DMYjnyhKLbz0SJsjiIUT7yQMuQuE4OHxTSrkbRIoNcxgyCGux88CEAC0YfDJkbufTgX2fGAVF9HH1EuWhcFORBB/8r+RiRW82XD00QERDug4+dIqg2iFj8i6/Qc5vuXyw4OUD9mTiuGiHNDQIpl2/iipTUbru6lENDGg1Bt58u138NrLvS0eEehvyA8Nt07Vdts3xv7gW5V4HywcFkorxyJD43ApCU9ydUYfBXE4gmLJ4mEXlt1bUvwdhYR0hGV2GVo0ONQeybHTJXE51CzNRZr+tbFuDS5EsDvKS6Wg4KRHEsUjF2eQ0kTv92wawigxvDc5BRHP7IpLhXf8ytAD38szbCJuHRNgW7QYTihCNnx5FyzdT68fcTdD1NdW/h9Go4ezjCtN1Mc0f1ZeNhRu/RhcH7IUksMmN317la+D9+BpN5v2cIQ2h1bJDwr0utbBHRGgH3noATMZPC0M6QXuuwCb0pnKIJukTpj9XXBUlfSe3rsRszEyZHBkdq1/7M9ojNQ/JsxdCOn8olkj0fzU2LhwLoVsPo7TB4iFnydTsaVwcNiDkAlaC10eN/uh2q+hGDTG77c5eXgcLMKSGnQkpyyERn6ay0cMoh66oUBzJ0tCVP6uUCOkCJn8YowhBpgO2ZmZyU08sJivmarbpuChCabu9aToYLRrg98aqwTmI4idFyMgujdmbgoIeyVtQf2h7fEhiSF9Pmm4fi6h3qxrchEnX3QS5U2f9zgYYPxsISJtBFx6uBgxDl5xIL3dpPkS9fYS/6g5DYShCJxrOHnIBqlR2auw0antUVRr6T+7kS519ENi8PkIYN4ZgYKwwM7u1yyxWJBOFQqK8ue1p+ftUoRHQeCKSx6lsMVKGFEPszlS5i7BmxzR5Wkk5HMJa1omBI7TSNp5YSYU+qMUcpOuOySm0ijGXF7Jla8h4Mnzszn//61//+r+DzuS66HooVrsqpPYQsIeYZac4uR/Zz5t1aRyIzEorfasAMcchu/gg6NWc2iW4L9K5YizpzP3RA7i6k1b6gFAEJb0HRhPcuZ/2cyHm9Y/G3V3j4Us/J4++dTtYb7cJo8H0W4h2fY/0TJOqYOdBth5KDTRxVmdo6lU5YCkKZzNIs3owdH3qmsZFlRcgrY4yLoBJxXuZWYD/uJJD8m23cxHWzT7NPfDk8Q5gTh91Fo/mhm36YnJOnf6NhAcjW1rpaptj3zA1Boej5g14DMszgdUnpjT1QWWGd4opXYqq6HX98YpRAN7ibqvKT+n68VYOvQ6uO/2HywZdqRiaTpDmTfC8yd0ipGdROeQUh+olvRp2OMqfY2S1CnHwMgIyKctXPSwOvoSMOQcvPfttbFTJuiFZfeiEkRdA2pcAIEPq4orupKH5g+1vTBUs0mAQpAM5lah6BmHhkOcvhOuukkmB9j49TEE6bWWkZn7Z6XQfnvTSvDi6f2MrJZncM5e6FpLJy/K+AzGD/STI8sHJfvkDwluNt6qJSVRtHxAguPwqSlrVWaPbqziZW/AYZfXa7d0v6MRDENDb3Y/ggojAQVyTzl2f3iX3549P05ViMZKZw0yBa2la72Srh3X4uruo1p35hNBFrxYZtLhqLPumY9THt+y8p/BXHP6+ujRFXIFIdNn4Y8TYD9FbUa1QMZAQcfqwzQrJCg5bjVhcDVzB1MbHjGYr1RyoPb7ZQET7d7aFB6/2pJiSoK5mI+cZszDG1pospN3owNv188+u6mwb42uZ2UuK3B/s1cSXhazsf0To2qWGMSTWDwoQo4SG/HbcVsXh29wbI1Quv0y21sssuv4SeuNu9fIVo6QVd0fKuNk+7PohLiWRU9mLQTTWbUxD6t5RqitPfwg06e8XAZDyBlhjXDGFNCCFaVj1vv2nf5ayFadmIsT1X4EhVC73sUJhvBvXr/v7pkaVVVoggetEs0uFlukOrYZ0S2XYLmQEUrS+TvME3LtS5d3DVb947j34tvMOiALV2xdsPjxrhcKSH2mFw3IQ6KaJmpYichVbJ8j48Wq1E2RouC2nZLxLRFV5dfUydpQ3bnYM0UZI/2EbFSgF0whbMZTPaRWkw7nuLfveOum1sZl0PBHS+tPLtTtSqFoNQ9zZwde4ET1/7RzjjN1ptlZzgXRI7NwxIXVLKWUvl/G4hVBRQ0qjB9xb45O1iE+zGfHw+/QwFdO8vZmksN3OTYbzkbrhQjy34g3WEUJI65WFYI2zJAZywyO00GKUPUN2fuFjt/Ntah+G9zNVXUPo8agnN0JVHd0Pix5hLE5bQiplIMc4Ri+7yIlOsYYuBm5QcbKcTZfd7rKv7Efo5uHq4b67nM4ehsXNqzS7Z1PKo2rhIJA2KR3EOOGzXrvVYdiD4FQBDo6uZg5Cr2OFXHo4uhox+m3yxqEnxNl8VI/io7QI6y1OBPudDSXrrV/hsZX7MC5VlB899LDn4qFi5V/KRkJZtYpsAbp/Tbg4zumDrSwiFhN5dt1BkV5o00Iy+lkK24/x9BahdVuDo5w5lbRbN3Oss5WaoHx2+B1g1z1U12vccmf7KWToeeX6dhS/vStIKmPxPdscfwy1khgXLDHlC2vB/oOXy5c9TsEgY68r1bn7Gs1nxxYtjGLHO+WsCl7fKmaAnGbcRv7VKwZXPbaZEOJ5pbs31WmZD9SrWNzsZTwklfzYebsv5do1R1Yew1ZWnuW2kdelM9cFQdue0Tb92mFb9tZJg4A0b+9h5V07WYqXbw3boVsvJq6suQhjsKPWzpUUvK9+zH3AOF1Dds8CKEnbTmnGXqZ0x+b7Oy9FzNkv0ZzN3LS+fpM84n51jEmiCSmGJae8ZLuMjqez8AppNsI2i0KWPIi2o9AzX7pj7qg78ssFgpp1Z5ItHXn0RDjwfEbPS6JzptnFFedECvASYuLYhyqgSswtp76ImUcNvPiS++r5iIkXQjOVxDXXiRRZhFsH3yuzRWK9uXa0ScTo+r73lDzv/bvY0+Ubp39mUvaTU6AC2fbxT/7A5YSIXCdjBCQdomftZeUdTZKZhzGVaZ+/k2MbC2p59pgHKpiEUabktJjrEKkgvXogVL7sQOgV/+hHZDmnGfh4Po9wPPshp0TiKEDKOtIUSEFUtfBgi3q34wlzDzFVpwiXHA5C2ItR7fDlJ28SadNBzD4UADSmJM49SlHyjs3dZLtSwyiXDS3uHPnBS0mI8jc3xB+PqvU8TLAz4T62ne+MtoYd6mxl7jrh4ZYxVft/K9tb8A0TrSv8h1G5rmFcStlT7uPqSTzfWIvYfWDS9SYDQ41xMOUA5KUYxtWjHy+0RtlnSPFLjl2AWS8VJ9O1Upsy2rVDP7xmTBV5NtRuHAmlcQSGEPg4BynsGiKOtTHGtYhrWPVEFr8s3BWK2533u33L5eKlGOQcB+vjI8BBLXHIvvW3CdDF4mQdIu9LRasX96qNcc8RiU58ICu/XjTbbmHQwySN//Aj2gFiQUQ4lnKPrc5WxPHc6jnYEZVSMos6Soj5Nay1XBoIjp5NIpz/YA4ahIO0wSXJuQQ1EOCkjHbxm9F66lXCMGlI/12VZ08X1UqE412P4CB5AVv9xgnTxyF6THwVoeb5moj52HqlGn68lWV1z8FluK/Sjpti+Yzl1u6W4hCmlT/WyLipSbeti2cpwcUEiEbYuF8cd2dbW7ttwmQ0fRlrwcI6Pp6PZGinV/1D3cQaYe2cbmT219cZwXMs28rui5mxmA+2U6wQWLtN8tHCT+nmU53KXixFYTz5KLs2VqpPbCSeSebXP6hj9JuK1WytEGGFjTsEMFOQTRQ+2QcSIHjkqVXwC1xgAyQvACsL0Uow2azmNUrVajMbq9ycsyzH8ZtXswnqH/z1w267/1NUfaZr3lolsskUnTEcx0qAiAd3CcIrSQDO47qAkMqItEQT/YB88C2CEcXqVH+aUdZt9p3RB3iggP5HYJPRlkhXNF2f/Z/BSXhRtd2CdBWXoxLnBeANYtkS3b7ejO/7kstH00WWT1OjUm5F2LchuYmXIpUqlfLS89HOnfszROPUeox+yyqfsbc5vU0CJ53HKOO0Wj24eUTh5yMtw2eonSDJVoL1Mieb8OrseUXnW77Gf55PWuwhkLTYc8k4GSJZS0QgXgHr4iWYYDo5KVKo6d9nA+09938qH7+PIFQtPAc1pLt1f6seibB1ThAsCwp/CgJXr0uRRMWvnzGH82n+5lPr3ybBWPPpRNxvejWt7K9F4wnd97PUK/Ln7bOMv2nskw3nY+fPVA1/JoSUMGqm2+1MWbMK3kTLQzTTbFYhtLGKb/QTl4V4bP93lD4pGW3seX+lUCgFy/ntaptYLcda5+1a8hN7v/cQOEcxGSsV6ombs3TM789ms35/rHbWTtQLlWB5+5Sin5e0Zjnpj8XS6XQs6E+Wd32b9OelbTf+D8S9E53oRCc60Yn+X5FxHPJHj+KghEXx05cg9hNO+ill9Zw8r//sNxZP6Oeqs5WbQqF9FrS2XpX9FukxKK46f6ffjHfdbVwpiv5tEt33mZQ8XLM3jqf0FFZfMUlG6I8Rq6EtGGAFyOM5SHIrRlTdMi6GawwcmYj5918AYdZ9d43+JZKvWhc4FIFX+Td+LR2wP8romjW3OBt7LujZssBBseVqgZGe9QvO7N08ek8ablv/HoEZyOrVRnNXkb4ZLpXPu7o6TKKnSPpT67/jogfk4Q6ECBsAAwGjtGZ8OshGyOlbeTRnX4FodRptInSXHwP0eTpC1vkN/a9wc2CEAQ+ExjTzkq9gtFLQJgoHoX4GnbPPxkAorSMMBAChIY7Wnl9doPM2QsGW0vjxEWJjAzubCeOqvpgUYN0I9fM8ccbqI9mJUEvrZFzGZ+jPNZuHQjRt0QFPb9mBEBubLwS6LQEbv6ZnBesI9UWaFP08M920GNiL0Kzt6JtVArx9XoGBUHI1mB4dIbrhneGKelGU/vpMPyTxPKD/CxZTgPZ8P0K6KoCJhRCb9X0bIbbp2AjN7fLm91jaEtWViomwdUOP2aN9mpKPj9O/7ENIKWwitJVtm4eHI9OWChqdRweh+RkRc09CrJbOZGpBAyFXoWfpC8+ghoKPS7d/EoQ8rQkmjc8AUITGaAWjhdA5i01HWNP/kdXQDeeTyt+BkI3pK+TagY/VN/q6AxIlw4ZThPq5HAHrrGCbDB7mqQmVymKCB5Na+PMI+XqK0i+HZaVrJ5BFFGHaQNjecFMGQkzbRaVgU6InvH0PQn1tPHBgYd2BUO/KDnDeCPV+fq4SZOk+3u9AaNJxEPI8/Yyti4ecgXDDiJsIqQwLhajgSyW/C6H+VuFICAttSJOMYwd0PawbeuiNUP+8F3X8vPZdUvoMLwU67Kcsd/hDfbQB8xRrakYNp2wi1KyjUG7Q9yA8orfYRqgfDw2hjIGwHDm/OatlbYTI7EynGzF/VoR5I6ZhjYXALAtKSj+eayLE5hc/6H5hF0I9DjcR6p8A+8QIsXESCM/S+Bob3tGKSykPjbicnnjoQujOTIyvnqS0vQhhMsIWHT/yTuu7WbkzPZTRrZFUdhDq314xjutxEDb1fFj/ZgLWP8YZYNFehB8aeSPN2DdDD8m4SNPdFwE27CAU6ZD5enoNITFukYJhJOonX3DWh5x2IBTaJYtqH5DjG+fw8WwhWjAmPO3YUuNwMF7/uoyDEFU2bolYTfm7/KHAmXTwHN+rTlMsGOe5CEYPFFew6jQ6QroRk08V1xFWzQ0M1i12vLCN8OiVKJ9vq4pxoRVcVST2XDcaNkLqTQRdCB2EGGddmw8C5i3eCDeaAIVDIozT7DYlbddLsZhhJdr1RJuCKsZoz+DiSIV2gUsp87qEnh3/YnRglJ8ljtf7o9hUyemYDfP6RSn7oKFj1ktRNqiT8ZER42fjVAwwb/ng2TnH8jexqpkk6hcnKYf98IPe3eXXb4mZPSZislLgWe78LFbFrtqL8dygjbAZ3KBDnrK7n6gdv/i73g6X03sONaAfT3+/rzqsdzvRiU50ohOd6EQnOtGJTnSiE53oRCc60YlOdKITuej/AExUChlca6BHAAAAAElFTkSuQmCC"  
	                alt="Logo HCMUTE" class ="mh-100 mw-100">
	            </div>
	            <div class="sidebar-brand-text mx-3">HCMUTE</div>
	        </a>
        	<li class="nav-item active mt-5">
                <a class="nav-link" href="index.jsp">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span >Giới thiệu chung</span></a>
            </li>
        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

                    <!-- Topbar Navigation -->
                    <ul class="navbar-nav" style="width: 100%;">
                    
                    	<li class ="nav-item">
							<a class ="nav-link text-gray-900 medium" href="#">Trang Chủ</a>
						</li>
						<li class ="nav-item">
							<a class ="nav-link text-gray-900 medium" href="#">Hỗ Trợ</a>
						</li>
                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow ml-auto">
                            <a class="nav-link dropdown-toggle" href="DangNhap.jsp">
                                <span class="mr-4 d-none d-lg-inline text-gray-900 medium">Đăng Nhập</span>
								<lord-icon
								    src="https://cdn.lordicon.com/kthelypq.json"
								    trigger="hover"
								    style="width:50px;height:50px">
								</lord-icon>
                            </a>                           
                        </li>
                    </ul>

                </nav>  

                <!-- Your Slide bar and main content goes here -->
				<div class="container h-100">
			        <div class="row h-100 justify-content-center align-items-center">
			            <table class="table">
						    <tbody>
						        <tr>
						            <td><label for="username" class="h4">Tài khoản:</label></td>
						            <td><input type="text" id="username" class="form-control"></td>
						        </tr>
						        <tr>
						            <td><label for="email" class="h4">Email:</label></td>
						            <td>
						                <div class="row">
						                    <div class="col"><input type="email" id="email" class="form-control"></div>
						                    <div class="col-auto"><button id="sendOTPBtn" class="btn btn-primary">Gửi mã</button></div>
						                </div>
						            </td>
						        </tr>
						        <tr>
						            <td><label for="otp" class="h4">OTP:</label></td>
						            <td>
						                <div class="row">
						                    <div class="col"><input type="text" id="otp" name="otp" class="form-control"></div>
						                    <div class="col-auto"><button class="btn btn-primary" id="confirmOTPBtn">Xác nhận mã</button></div>
						                </div>
						            </td>
						        </tr>
						        <tr id="new-password-row" style="display: none;">
						            <td><label for="new-password" class="h4">Mật khẩu mới:</label></td>
						            <td><input type="password" id="new-password" class="form-control"></td>
						        </tr>
						        <tr>
						            <td></td>
						            <td><button id="changePasswordBtn" class="btn btn-primary" style="display: none;">Đổi mật khẩu</button></td>
						        </tr>
						    </tbody>
						</table>

			        </div>
			    </div>
            <!-- End of Main Content -->

            <!-- Footer -->
    			<jsp:include page="./footer.jsp" />
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>
    <!-- Bootstrap core JavaScript-->
    
    <jsp:include page="./Scripts.jsp" />
    <script>
    $(document).ready(function () {
    	var username = sessionStorage.getItem('username');
        var email = sessionStorage.getItem('email');

        $("#username").val(username);
        $("#email").val(email);
        $("#sendOTPBtn").click(function () {
            var username = $("#username").val();
            var email = $("#email").val();
			console.log("Đã click");
            if (username && email) {
                $.ajax({
                    type: "POST",
                    url: "<%= request.getContextPath() %>/GuiOTP",
                    data: { username: username, email: email },
                    success: function (response) {
                        console.log(response);
                        console.log(username);
                        sessionStorage.setItem('username', username);
                        sessionStorage.setItem('email', email);
                        window.location.href = '<%= request.getContextPath() %>/QuenMatKhau.jsp';
                    },
                    error: function (error) {
                        console.log(error);
                    }
                });
            } else {
                alert("Vui lòng nhập đầy đủ thông tin Tài khoản và Email.");
            }
        });
        $("#confirmOTPBtn").click(function () {
        	console.log("Đã click xác nhận");
            var enteredOTP = $("#otp").val();
            var trueOTP = "${sessionScope.TRUEOTP}";

        	console.log(trueOTP);
            if (enteredOTP === trueOTP) {
                <% session.removeAttribute("TRUEOTP");%>
                $("#new-password-row, #changePasswordBtn").show();
                $("#sendOTPBtn").prop("disabled", true);
            	$("#confirmOTPBtn").prop("disabled", true);
            } else {            	
                alert("OTP is incorrect. Please try again.");
            }
        });
        $("#changePasswordBtn").click(function () {
            var username = $("#username").val();
            var newPassword = $("#new-password").val();

            $.ajax({
                type: "POST",
                url: "<%= request.getContextPath() %>/DoiMatKhau",
                data: {
                    username: username,
                    newPassword: newPassword
                },
                success: function (response) {
                    alert("Mật khẩu đã được thay đổi thành công!");
                	window.location.href = '<%= request.getContextPath() %>/DangNhap.jsp';
                },
                error: function (error) {
                    console.log("Error changing password: ", error);
                }
            });
        });
    });
</script>
<% if (session.getAttribute("SendMessage") != null) { %>
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title" id="myModalLabel">Thông báo</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        ${SendMessage}
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">Thoát</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- JavaScript to trigger the modal -->
        <script>
            $(document).ready(function() {
            	console.log('Document ready function');
                $('#myModal').modal('show');
                <% session.removeAttribute("SendMessage");%>
            });
        </script>
    <% } %>
</body>
</html>