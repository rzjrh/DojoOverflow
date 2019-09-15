package com.RezaAk.web.DojoOverflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.RezaAk.web.DojoOverflow.models.Answer;
import com.RezaAk.web.DojoOverflow.models.Question;
import com.RezaAk.web.DojoOverflow.models.Tag;
import com.RezaAk.web.DojoOverflow.services.OverflowService;

@Controller
public class OverflowController {
	private final OverflowService service;
	
	public OverflowController(OverflowService justPassingBy) {
		this.service = justPassingBy;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Question> questions = service.allQuestions();
		model.addAttribute("questions", questions);
		return "questions.jsp";
	}
	
	@RequestMapping("/question/{id}")
	public String one(Model model, @PathVariable("id") Long id, @ModelAttribute("answer") Answer answer) {
		Question Que = service.getQuestion(id);
		model.addAttribute("question", Que);
		return "one.jsp";
	}
	
	@RequestMapping("/new")
	public String newQuestion() {
		return "new.jsp";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String create(@RequestParam("question") String question, @RequestParam("tag") String tag) {	
		Question Que = new Question(question);
		Tag Ta = new Tag(tag);
		
		Question newQue = service.createQuestion(Que);
		Tag newTag = service.createTag(Tag);
		
		newTag.addQuestion(newQue);
		
		service.createQuestion(newQue);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/question/{id}", method = RequestMethod.POST)
	public String postAnswer(Model model,@PathVariable("id") Long id, @Valid @ModelAttribute("answer") Answer answer, BindingResult result) {
		if(result.hasErrors()) {
			Question Que = service.getQuestion(id);
			model.addAttribute("question", Que);
			return "one.jsp";
		}
		else {
			Question que = service.getQuestion(id);
			Answer A = new Answer(answer.getContent(), que);
			service.createAnswer(A);
			return "redirect:/question/"+id;
		}
	}

}


