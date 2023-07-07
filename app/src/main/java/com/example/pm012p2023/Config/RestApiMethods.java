package com.example.pm012p2023.Config;

public class RestApiMethods
{
    public static final String ipaddress = "192.168.210.217";
    public static final String webapi = "pm01";
    public static final String separador = "/";

    // Routing -- CRUD
    public static final String postRouting = "EmpleCreate.php";
    public static final String getRouting = "EmpleRead.php";
    public static final String updRouting = "EmpleUpdate.php";
    public static final String delRouting = "EmpleDelete.php";

    // Endpoint
    public static final String ApiPost = "http://"+ipaddress+ separador +webapi + separador +postRouting;
    public static final String ApiGet = "http://"+ipaddress+ separador +webapi + separador +getRouting;
    public static final String Apiupd = "http://"+ipaddress+ separador +webapi + separador +updRouting;
    public static final String Apidel = "http://"+ipaddress+ separador +webapi + separador +delRouting;

}
