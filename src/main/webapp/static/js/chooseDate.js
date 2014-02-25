(function($){
	var state = false;
	var initLayout = function() {
		$('#date').DatePicker({
			flat: true,
			date: '2008-07-31',
			current: '2008-07-31',
			calendars: 1,
			starts: 1,
			view: 'years'
		});
		
		var now3 = new Date();
		now3.addDays(-6);
		var now4 = new Date()
		$('#widgetCalendar').DatePicker({
			flat: true,
			format: 'Y-m-d',
			date: [new Date(now3), new Date(now4)],
			calendars: 1,
			mode: 'range',
			starts: 1,
			onChange: function(formated) {
				$('#widgetField span').get(0).innerHTML = formated.join(' 至 ');
			}
		});
		
		$('#widgetField>a').bind('click', function(){
			$('#widgetCalendar').stop().animate({height: state ? 0 : $('#widgetCalendar div.datepicker').get(0).offsetHeight}, 500);
			state = !state;
			return false;
		});
		$('#widgetCalendar div.datepicker').css('position', 'absolute');
	};
	
	var showTab = function(e) {
		var tabIndex = $('ul.navigationTabs a')
							.removeClass('active')
							.index(this);
		$(this)
			.addClass('active')
			.blur();
		$('div.tab')
			.hide()
				.eq(tabIndex)
				.show();
	};
	
	//隐藏日历
	$(':not(#widgetCalendar,#widgetField>a)').bind('click',function(){
		$('#widgetCalendar').stop().animate({height:  0 }, 500);
		state = false;
	});
	
	EYE.register(initLayout, 'init');
})(jQuery)