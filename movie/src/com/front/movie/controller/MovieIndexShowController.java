package com.front.movie.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.front.actor.entity.Actor;
import com.front.actor.service.ActorServiceImpl;
import com.front.movie.entity.Movie;
import com.front.movie.service.BigDataImpl;
import com.front.movie.service.MovieServiceImpl;
import com.front.movie.service.MovieTypeServiceImpl;
import com.front.user.entity.User;


@Controller
public class MovieIndexShowController {
	
	@Resource
	private MovieServiceImpl msi;
	@Resource
	private ActorServiceImpl asi;
	@Resource
	private MovieTypeServiceImpl mtsi;
	@Resource
	private BigDataImpl bdi;
	
	
	//主页轮播图
	@GetMapping("/indexshow")
	public String IndexShow(HttpServletRequest request) throws Exception {
		User u = (User)request.getSession().getAttribute("user");
		if(u!=null){
			request.setAttribute("map", bdi.getUserRecommend(u));
			request.setAttribute("hatemap", bdi.getHateRecommend(u));
		}
		List<Movie> mov=this.msi.searchAllMovie();
		List<Movie>  mo=new ArrayList<Movie>();
		for(int i=0;i<9;i++){
			int rm = (int) (Math.random() * mov.size());
			mo.add(mov.get(rm));
		}
		
		request.setAttribute("movielist", mo);
		List<Actor> al=this.asi.findActors();
		
		List<Actor> ac=new ArrayList<Actor>();
		for(int i=0;i<9;i++){
			int ran = (int) (Math.random() * al.size());
			ac.add(al.get(ran));
		}
		request.setAttribute("actorlist", ac);
		
		List l = mtsi.searchAllMovieType();
		Map map = new HashMap();
        List listNew = new ArrayList();
        while (map.size() < 4) {
            int random = (int) (Math.random() * l.size());
            if (!map.containsKey(random)) {
                map.put(random, "");
                //System.out.println(random + "===========" + l.get(random));
                listNew.add(l.get(random));
            }
        }
        request.setAttribute("typelist", listNew);
        
        List suckl = msi.searchSuck();
        
        
        
        Map suckmap = new HashMap();
        List listSuck = new ArrayList();
        
        while(suckmap.size()<6){
        	int random = (int) (Math.random()*suckl.size());
        	if(!suckmap.containsKey(random)){
        		suckmap.put(random,"");
        		listSuck.add(suckl.get(random));
        	}
        }
        

        request.setAttribute("sucklist", listSuck);
        
		
		return "/index";
	}
}
