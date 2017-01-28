package com.seven.eleven.controllers;

import com.seven.eleven.Model.SevenElevenModel;
import com.seven.eleven.Model.SevenElevenRepo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

/**
 * Created by JPMPC-B210 on 1/6/2017.
 */

@Controller
public class ElevenController {

    private SevenElevenRepo sevenElevenRepo;

    @Autowired
    public ElevenController(SevenElevenRepo sevenElevenRepo) {
        this.sevenElevenRepo = sevenElevenRepo;
    }

    @RequestMapping(value = {"/registration"}, method = RequestMethod.GET)
    public String loadHomepage() {
        return "registration/registration";
    }

    @RequestMapping(value = {"/view"}, method = RequestMethod.GET)
    public ModelAndView loadView(ModelAndView viewModel) {
        viewModel.addObject("view", sevenElevenRepo.findAll());
        viewModel.setViewName("registration/view");
        return viewModel;
    }

    @RequestMapping(value = {"/user/{id}"}, method = RequestMethod.GET)
    public ModelAndView loadUser(@PathVariable int id, ModelAndView idModel) {
        idModel.addObject("id", sevenElevenRepo.findOne(id));
        idModel.setViewName("registration/user");
        return idModel;
    }

    @RequestMapping(value = {"/thankyou"}, method = RequestMethod.POST)
    public void loadThankYou(@ModelAttribute @Valid SevenElevenModel sevenElevenModel,
                              Errors errorField,
                              BindingResult bindingResult,
                              HttpServletResponse resp,
                              ModelAndView model, WebRequest request,
                              HttpServletResponse response) {

        try {
            PrintWriter out = response.getWriter();
            JSONObject obj = new JSONObject();
            JSONArray list = new JSONArray();
            JSONArray errorMsg = new JSONArray();
            if (!errorField.hasErrors()) {
                obj.put("message","success");
                obj.put("name",sevenElevenModel.getName());
                //model.setViewName("registration/thankyou");
                sevenElevenRepo.save(sevenElevenModel);
            }else{
                List<FieldError> errs = bindingResult.getFieldErrors();
                for(FieldError error : errs){
                    list.add(error.getField());
                    errorMsg.add(error.getField());
                    //errMsg.add(error.getDefaultMessage());
                    obj.put(error.getField(),error.getDefaultMessage());
                    //obj.put("errorField",list);
                }
            }
            out.print(obj);
            }   catch (Exception e) {
            e.toString();
        }
    }
}

