package web.view;

import org.springframework.beans.PropertyAccessException;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DefaultBindingErrorProcessor;
import org.springframework.validation.FieldError;

public class MuBindingErrorProcessor extends DefaultBindingErrorProcessor {
	
	//重写自定义错误提示
	@Override
	public void processPropertyAccessException(PropertyAccessException ex,
			BindingResult bindingResult) {
		String field = ex.getPropertyName();
		String[] codes = bindingResult.resolveMessageCodes(ex.getErrorCode(), field);
		Object[] arguments = getArgumentsForBindError(bindingResult.getObjectName(), field);
		Object rejectedValue = ex.getValue();
		if (rejectedValue != null && rejectedValue.getClass().isArray()) {
			rejectedValue = StringUtils.arrayToCommaDelimitedString(ObjectUtils.toObjectArray(rejectedValue));
		}
		bindingResult.addError(new FieldError(
				bindingResult.getObjectName(), field, rejectedValue, true,
				codes, arguments, "输入格式错误"));
	}
	
}
