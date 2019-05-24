package com.happyforce.get;

import com.happyforce.objetos.Comment;
import com.happyforce.objetos.UserMongo;
import com.happyforce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
public class ConsultasMongo {

    @Autowired
    private UserRepository userR;

    @RequestMapping(path="/usuariosmongo")
    @ResponseBody
    ResponseEntity<List<UserMongo>> usuarios() {

        List<UserMongo> listaUsers= userR.findAll();

        HttpHeaders responseHeaders = new HttpHeaders();
        List<MediaType> medias = new ArrayList<>();
        medias.add(MediaType.ALL);
        responseHeaders.setAccept(medias);
        return new ResponseEntity<>(listaUsers, responseHeaders, HttpStatus.OK);
    }

}
