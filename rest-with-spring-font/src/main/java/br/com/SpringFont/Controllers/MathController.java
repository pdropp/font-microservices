package br.com.SpringFont.Controllers;

import br.com.SpringFont.Exeception.ResourceNotFoundExeception;
import br.com.SpringFont.Functions.SimpleMath;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

import static br.com.SpringFont.Functions.NumberConverter.convertToDouble;
import static br.com.SpringFont.Functions.NumberConverter.isNumeric;


@RestController
public class MathController {

    SimpleMath math = new SimpleMath();

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/sum/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double sum(
            @PathVariable(value="numberOne")String numberOne,
            @PathVariable(value="numberTwo")String numberTwo

    ) throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new ResourceNotFoundExeception("Please set a numeric value");
        }
        
     return math.sum(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping(value="/sub/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double Sub(
            @PathVariable(value="numberOne")String numberOne,
            @PathVariable(value="numberTwo")String numberTwo

    ) throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new ResourceNotFoundExeception("Please set a numeric value");
        }

        return math.sub(convertToDouble(numberOne), convertToDouble( numberTwo));
    }

    @RequestMapping(value="/multi/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double Multi(
            @PathVariable(value="numberOne")String numberOne,
            @PathVariable(value="numberTwo")String numberTwo

    ) throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new ResourceNotFoundExeception("Please set a numeric value");
        }

        return math.multi(convertToDouble(numberOne), convertToDouble( numberTwo));
    }

    @RequestMapping(value="/div/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double Div(
            @PathVariable(value="numberOne")String numberOne,
            @PathVariable(value="numberTwo")String numberTwo

    ) throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new ResourceNotFoundExeception("Please set a numeric value");
        }

        return math.div(convertToDouble(numberOne), convertToDouble( numberTwo));
    }

    @RequestMapping(value="/raizQuadrad/{number}", method= RequestMethod.GET)
    public Double raizQuadrad(
            @PathVariable(value="number")String number

    ) throws Exception{
        if(!isNumeric(number)) {
            throw new ResourceNotFoundExeception("Please set a numeric value");
        }

        return math.raizQuad(convertToDouble(number));
    }



}
