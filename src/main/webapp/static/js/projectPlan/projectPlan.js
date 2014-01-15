/**
 * 验证日期大小的方法
 */
function checkDate(startTime, endTime) {
	var start = new Date(startTime.replace("-", "/").replace("-", "/"));
	var end = new Date(endTime.replace("-", "/").replace("-", "/"));
	if (end < start) {
		return false;
	}
	return true;
}

function pushDate(startObj, endObj, nextObj, nextEndObj, message) {
	// 获取开始时间
	var startTime = $("input[name='" + startObj + "']").val();
	// 获取结束时间
	var date = $("input[name='" + endObj + "']").val();
	// 判断时间是否大于计划开始时间
	if (checkDate(startTime, date)) {
		if (nextObj != null) {
			if (nextEndObj != null) {
				var nextEndObjDate = $("input[name='" + nextEndObj + "']")
						.val();
				if (nextEndObjDate != null && !checkDate(date, nextEndObjDate)) {
					$('#' + nextObj).datebox('setValue', "");
					$('#' + nextEndObjDate).datebox('setValue', "");
				} else {
					// 自动带出到下一个input框
					$('#' + nextObj).datebox('setValue', date);
				}
			} else {
				// 自动带出到下一个input框
				$('#' + nextObj).datebox('setValue', date);
			}

		}
	} else {
		// 清空时间
		base.tips(message, 'error');
		if (nextObj != null) {
			$('#' + nextObj).datebox('setValue', "");
		}
		$('#' + endObj).datebox('setValue', "");
	}
}

// 获取当前时间
function getCurrentDate() {
	var curr_time = new Date();
	var strDate = curr_time.getFullYear() + "-";
	strDate += curr_time.getMonth() + 1 + "-";
	strDate += curr_time.getDate();
	return strDate;
}

$(function() {
	// 检查日期是否合法
	$("#endTimeOfDesign").datebox({
		onSelect : function() {
			pushDate("startTimeOfDesign", 'endTimeOfDesign',
					'startTimeOfImplement', 'endTimeOfImplement',
					'设计计划结束时间必须大于开始时间');
		}
	});
	$("#startTimeOfDesign").datebox({
		onSelect : function() {
			var strDate = getCurrentDate(); // 获取系统当前时间
			var startTimeOfDesign = $("#startTimeOfDesign").datebox("getValue"); // 获取选择的时间
			// 设计计划开始时间必须大于当前系统时间
			if (!checkDate(strDate, startTimeOfDesign)) {
				base.tips("设计开始时间必须大于当前系统时间", 'error');
				$("#startTimeOfDesign").datebox('setValue', ""); // 清空时间
				return;
			}
			pushDate("startTimeOfDesign", 'endTimeOfDesign',
					'startTimeOfImplement', null, '设计计划结束时间必须大于开始时间');
		}
	});
	$("#endTimeOfImplement").datebox({
		onSelect : function() {
			pushDate("startTimeOfImplement", 'endTimeOfImplement',
					'startTimeOfCheck', 'endTimeOfCheck', '实施计划结束时间必须大于开始时间');
		}
	});
	$("#startTimeOfImplement").datebox({
		onSelect : function() {
			pushDate("endTimeOfDesign", "startTimeOfImplement", null, null,
					"实施计划开始时间必须大于设计结束时间");
			pushDate("startTimeOfImplement", 'endTimeOfImplement',
					'startTimeOfCheck', null, '实施计划结束时间必须大于开始时间');
		}
	});
	$("#endTimeOfCheck").datebox({
		onSelect : function() {
			pushDate("startTimeOfCheck", 'endTimeOfCheck', null, null,
					'验收计划结束时间必须大于开始时间');
		}
	});
	$("#startTimeOfCheck").datebox({
		onSelect : function() {
			pushDate("startTimeOfCheck", 'endTimeOfCheck', null, null,
					'验收计划结束时间必须大于开始时间');
			pushDate("endTimeOfImplement", "startTimeOfCheck", null, null,
					"验收计划开始时间必须大于实施结束时间");
		}
	});
});