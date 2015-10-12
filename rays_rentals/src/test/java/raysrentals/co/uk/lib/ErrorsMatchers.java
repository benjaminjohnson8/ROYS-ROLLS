package raysrentals.co.uk.lib;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;

public class ErrorsMatchers
{
	public static ResultMatcher attributeHasGlobalErrors(final String name, final String... globalErrorCodes)
	{
		return new ResultMatcher()
		{
			@Override
			public void match(MvcResult mvcResult) throws Exception
			{
				ModelAndView mav = mvcResult.getModelAndView();
				BindingResult result = (BindingResult) mav.getModel().get(BindingResult.MODEL_KEY_PREFIX + name);
				assertTrue("No BindingResult for attribute: " + name, result != null);
				assertTrue("No errors for attribute: [" + name + "]", result.hasErrors());
				for (final String errorCodeToFind : globalErrorCodes)
				{
					List<ObjectError> globalErrors = result.getGlobalErrors();

					boolean foundCode = false;
					for (ObjectError globalError : globalErrors)
					{
						String code = globalError.getCode();
						if (errorCodeToFind.equals(code))
						{
							foundCode = true;
							break;
						}
					}
					assertTrue("No global error: [" + errorCodeToFind + "] of attribute [" + name + "]", foundCode);
				}
			}
		};
	}
	
	public static ResultMatcher attributeHasFieldErrors(final String attributeName, final String... fieldErrorCodes)
	{
		return new ResultMatcher()
		{
			@Override
			public void match(MvcResult mvcResult) throws Exception
			{
				ModelAndView mav = mvcResult.getModelAndView();
				BindingResult result = (BindingResult) mav.getModel().get(BindingResult.MODEL_KEY_PREFIX + attributeName);
				assertTrue("No BindingResult for attribute: " + attributeName, result != null);
				assertTrue("No errors for attribute: [" + attributeName + "]", result.hasErrors());
				for (final String errorCodeToFind : fieldErrorCodes)
				{
					List<FieldError> fieldErrors = result.getFieldErrors();

					boolean foundCode = false;
					for (FieldError fieldError : fieldErrors)
					{
						String code = fieldError.getCode();
						if (errorCodeToFind.equals(code))
						{
							foundCode = true;
							break;
						}
					}
					assertTrue("No global error: [" + errorCodeToFind + "] of attribute [" + attributeName + "]", foundCode);
				}
			}
		};
	}
}
