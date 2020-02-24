<%@page import="org.apache.tomcat.util.codec.binary.Base64"%>
<form action="?pid= <% // Encode data on your side using BASE64
    out.print(new String(Base64.encodeBase64("algo&menu=12".getBytes())));%> " method="post">
    <div class="form-group">
        <label for="exampleInputEmail1">Email addresssssss</label>
        <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email">
        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" class="form-control" id="exampleInputPassword1" name="password">
    </div>
    <div class="form-group form-check">
        <input type="checkbox" class="form-check-input" id="exampleCheck1">
        <label class="form-check-label" for="exampleCheck1">Check me out</label>
    </div>
    <button type="submit" name="boton" value="elboton" class="btn btn-primary">Submit</button>
</form>
