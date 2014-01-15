/**
 * Boxy 0.1.4 - Facebook-style dialog, with frills
 *
 * (c) 2008 Jason Frame
 * Licensed under the MIT License (LICENSE)
 */
/**
 * 修订：yijay，
 * 修订内容：修订了用于成绩管理系统的年级，班级选择器，支持1,2,3层多层选择器的内容。
 * 支持：本js插件需要jquery1.4.1版本的支持，为了防止本系统中其他版本的jquery版本冲突，
 * 这里将jquery1.4.1版本的控制权命名为：jQuerymin
 */
var selecter;//此全局变量用于判断弹出层是否已经打开，否则会出现在ie下面，重复重构选择器的情况。
jQuerymin.fn.boxy = function(options) {
    options = options || {};
    return this.each(function() {      
        var node = this.nodeName.toLowerCase(), self = this;
        if (node == 'a') {
            jQuerymin(this).click(function() {
                var active = Boxy.linkedTo(this),
                    href = this.getAttribute('href'),
                    localOptions = jQuerymin.extend({actuator: this, title: this.title}, options);
                    
                if (active) {
                    active.show();
                } else if (href.indexOf('#') >= 0) {
                    var content = jQuerymin(href.substr(href.indexOf('#'))),
                        newContent = content.clone(true);
                    content.remove();
                    localOptions.unloadOnHide = false;
                    new Boxy(newContent, localOptions);
                } else { // fall back to AJAX; could do with a same-origin check
                    if (!localOptions.cache) localOptions.unloadOnHide = true;
                    Boxy.load(this.href, localOptions);
                }
                
                return false;
            });
        } else if (node == 'form') {
            jQuerymin(this).bind('submit.boxy', function() {
                Boxy.confirm(options.message || '请确认：', function() {
                    jQuerymin(self).unbind('submit.boxy').submit();
                });
                return false;
            });
        }
    });
};

//
// Boxy Class

function Boxy(element, options) {
    
    this.boxy = jQuerymin(Boxy.WRAPPER);
    jQuerymin.data(this.boxy[0], 'boxy', this);
    
    this.visible = false;
    this.options = jQuerymin.extend({}, Boxy.DEFAULTS, options || {});
    
    if (this.options.modal) {
        this.options = jQuerymin.extend(this.options, {center: true, draggable: false});
    }
    
    // options.actuator == DOM element that opened this boxy
    // association will be automatically deleted when this boxy is remove()d
    if (this.options.actuator) {
        jQuerymin.data(this.options.actuator, 'active.boxy', this);
    }
    
    this.setContent(element || "<div></div>");
    this._setupTitleBar();
    
    this.boxy.css('display', 'none').appendTo(document.body);
    this.toTop();

    if (this.options.fixed) {
        if (jQuerymin.browser.msie && jQuerymin.browser.version < 7) {
            this.options.fixed = false; // IE6 doesn't support fixed positioning
        } else {
            this.boxy.addClass('fixed');
        }
    }
    
    if (this.options.center && Boxy._u(this.options.x, this.options.y)) {
        this.center();
    } else {
        this.moveTo(
            Boxy._u(this.options.x) ? this.options.x : Boxy.DEFAULT_X,
            Boxy._u(this.options.y) ? this.options.y : Boxy.DEFAULT_Y
        );
    }
    
    if (this.options.show) this.show();

};


Boxy.EF = function() {};

jQuerymin.extend(Boxy, {

    WRAPPER: "<table cellspacing='0' cellpadding='0' border='0' class='boxy-wrapper'>" +
                "<tr><td class='top-left'></td><td class='top'></td><td class='top-right'></td></tr>" +
                "<tr><td class='left'></td><td class='boxy-inner'></td><td class='right'></td></tr>" +
                "<tr><td class='bottom-left'></td><td class='bottom'></td><td class='bottom-right'></td></tr>" +
                "</table>",

   
    DEFAULTS: {
        title: null,           // titlebar text. titlebar will not be visible if not set.
        closeable: true,           // display close link in titlebar?
        draggable: true,           // can this dialog be dragged?
        clone: false,          // clone content prior to insertion into dialog?
        actuator: null,           // element which opened this dialog
        center: true,           // center dialog in viewport?
        show: true,           // show dialog immediately?
        modal: false,          // make dialog modal?
        fixed: true,           // use fixed positioning, if supported? absolute positioning used otherwise
        closeText: '[关闭]',      // text to use for default close link
        unloadOnHide: false,          // should this dialog be removed from the DOM after being hidden?
        clickToFront: false,          // bring dialog to foreground on any click (not just titlebar)?
        behaviours: Boxy.EF,        // function used to apply behaviours to all content embedded in dialog.
        afterDrop: Boxy.EF,        // callback fired after dialog is dropped. executes in context of Boxy instance.
        afterShow: Boxy.EF,        // callback fired after dialog becomes visible. executes in context of Boxy instance.
        afterHide: Boxy.EF,        // callback fired after dialog is hidden. executed in context of Boxy instance.
        beforeUnload: Boxy.EF         // callback fired after dialog is unloaded. executed in context of Boxy instance.
    },

    DEFAULT_X: 50,
    DEFAULT_Y: 50,
    zIndex: 1337,
    dragConfigured: false, // only set up one drag handler for all boxys
    resizeConfigured: false,
    dragging: null,

    // load a URL and display in boxy
    // url - url to load
    // options keys (any not listed below are passed to boxy constructor)
    //   type: HTTP method, default: GET
    //   cache: cache retrieved content? default: false
    //   filter: jQuerymin selector used to filter remote content
    load: function (url, options) {

        options = options || {};

        var ajax = {
            url: url, type: 'GET', dataType: 'html', cache: false, success: function (html) {
                html = jQuerymin(html);
                if (options.filter) html = jQuerymin(options.filter, html);
                new Boxy(html, options);
            }
        };

        jQuerymin.each(['type', 'cache'], function () {
            if (this in options) {
                ajax[this] = options[this];
                delete options[this];
            }
        });

        jQuerymin.ajax(ajax);

    },

    // allows you to get a handle to the containing boxy instance of any element
    // e.g. <a href='#' onclick='alert(Boxy.get(this));'>inspect!</a>.
    // this returns the actual instance of the boxy 'class', not just a DOM element.
    // Boxy.get(this).hide() would be valid, for instance.
    get: function (ele) {
        var p = jQuerymin(ele).parents('.boxy-wrapper');
        return p.length ? jQuerymin.data(p[0], 'boxy') : null;
    },

    // returns the boxy instance which has been linked to a given element via the
    // 'actuator' constructor option.
    linkedTo: function (ele) {
        return jQuerymin.data(ele, 'active.boxy');
    },

    // displays an alert box with a given message, calling optional callback
    // after dismissal.
    alert: function (message, callback, options) {
        return Boxy.ask(message, ['确认'], callback, options);
    },

    // displays an alert box with a given message, calling after callback iff
    // user selects OK.
    confirm: function (message, after, options) {
        return Boxy.ask(message, ['确认', '取消'], function (response) {
            if (response == '确认') after();
        }, options);
    },

    // asks a question with multiple responses presented as buttons
    // selected item is returned to a callback method.
    // answers may be either an array or a hash. if it's an array, the
    // the callback will received the selected value. if it's a hash,
    // you'll get the corresponding key.
    ask: function (question, answers, callback, options) {

        options = jQuerymin.extend({ modal: true, closeable: false },
                                options || {},
                                { show: true, unloadOnHide: true });

        var body = jQuerymin('<div></div>').append(jQuerymin('<div class="question"></div>').html(question));

        // ick
        var map = {}, answerStrings = [];
        if (answers instanceof Array) {
            for (var i = 0; i < answers.length; i++) {
                map[answers[i]] = answers[i];
                answerStrings.push(answers[i]);
            }
        } else {
            for (var k in answers) {
                map[answers[k]] = k;
                answerStrings.push(answers[k]);
            }
        }

        var buttons = jQuerymin('<form class="answers"></form>');
        buttons.html(jQuerymin.map(answerStrings, function (v) {
            //add by zhangxinxu http://www.zhangxinxu.com 给确认对话框的确认取消按钮添加不同的class
            var btn_index;
            if (v === "确认") {
                btn_index = 1;
            } else if (v === "取消") {
                btn_index = 2;
            } else {
                btn_index = 3;
            }
            //add end.  include the 'btn_index' below 
            return "<input class='boxy-btn" + btn_index + "' type='button' value='" + v + "' />";
        }).join(' '));

        jQuerymin('input[type=button]', buttons).click(function () {
            var clicked = this;
            Boxy.get(this).hide(function () {
                if (callback) callback(map[clicked.value]);
            });
        });

        body.append(buttons);

        new Boxy(body, options);

    },

    // 行业类型选择器
    // value 表示选定的地区编号，字符创类型，编号间以逗号分隔
    // callback 表示回调
    // option 为json格式的可选项的集合
    industry: function (value, callback, options) {
    	if(selecter && selecter.isVisible()){
    		return;
    	}

        options = jQuerymin.extend({ modal: true, closeable: true, fixed: false },
                                options || {},
                                { show: true, unloadOnHide: true });

        var optionItems = "";
        var arrSelItems = new Array();
        //最大选择项数
        var maxSelectedCount = 20;

        var industry = jQuerymin('<div></div>').append('<div id="industry-main"></div>').css("padding-bottom", "0");

        //获取行业主体句柄
        var main = jQuerymin("#industry-main", industry);

        //头部
        var head = jQuerymin('<div id="ind-head" style="display:none;"></div>').html("<div class='head-title' style='font-weight:bold;height:16px;line-height:16px;'>你的选择结果</div><ul id='ind-result'></ul>");

        //设置行业选择项
        SetIndustryOptionItems();

        //主体部分
        var body = jQuerymin("<div id='ind-body'></div>").html(optionItems);

        //脚部
        var foot = jQuerymin("<div id='ind-foot'><span id='ind-msg'></span><span id='ind-cancel' >取消</span><span id='ind-submit'>确定</span></div>");

        //将头部，主体内容和脚部加入
        main.append(head).append(body).append(foot);

        //初始化选定行业
        InitSelData();

        //设置行业选择项
        function SetIndustryOptionItems() {
            for (var i = 0; i < arrsubject.length; i++) {
                if (arrsubject[i].className.length < 16) {
                    optionItems += "<a id='indItem" + arrsubject[i].classId + "' href='javascript:void(0);'><input type='checkbox' /><span style='padding-left: 2px;' id='indTd" + arrsubject[i].classId + "'>" + arrsubject[i].className + "</span></a>";
                } else {
                    optionItems += "<a id='indItem" + arrsubject[i].classId + "' href='javascript:void(0);' class='big-item'><input type='checkbox' /><span style='padding-left: 2px;' id='indTd" + arrsubject[i].classId + "'>" + arrsubject[i].className + "</span></a>";
                }
            }
        };

        //设置行业选择器样式
        function SetIndustryStyle() {
            var title_bar = jQuerymin(".title-bar", industry.parent());
            title_bar.css({ "background-color": "#1E90FF", "padding": 8 });
            jQuerymin(".close", title_bar).css({ right: 8, top: 7 });
        };

        //初始化选定行业
        function InitSelData() {

            var items = (value + ",").split(",");
            arrSelItems = new Array();

            for (var i = 0; i < items.length - 1; i++) {

                for (var j = 0; j < arrsubject.length; j++) {
                    if (items[i] == arrsubject[j].classId) {
                        //添加选定行业
                        arrSelItems.push(arrsubject[j]);
                    }
                }
            }
            var isInit = true;
            //更新选择结果集合
            UpdateIndSelItems(isInit);
            //更新被选项状态
            UpdateIndCheckedStatus();
        };

        //更新被选择项
        function UpdateIndSelItems(isInit) {

            var element = jQuerymin("#ind-result", head);
            //清空DOM中的选择结果
            element.empty();
            //若不存在选择结果，则隐藏选择结果部分
            if (arrSelItems.length == 0) {
                head.slideUp(400);
            }
            else {
                if (isInit) {
                    head.show();
                }
                else {
                    head.slideDown(400);
                }
                var items = "";
                //循环添加父类和子类被选择项
                for (var i = 0; i < arrSelItems.length; i++) {
                    items += "<li class='indResultItem'><div class='result-pad-left'></div><span id='indSel" + arrSelItems[i].classId + "' >" + arrSelItems[i].className + "</span></li>";
                }
                if (items != "") {
                    element.append(items);

                    //为新添加项注册事件
                    jQuerymin(".indResultItem", element).click(function (event) {
                        var ele = jQuerymin(event.target);

                        if (ele.attr("class") && ele.attr("class") == "indResultItem") {
                            DelIndSelItem(event);
                            UpdateIndSelItems();
                            UpdateIndCheckedStatus();
                        }
                    });

                    var resultEle = jQuerymin("li", element);
                    resultEle.hover(function (event) {
                        var targetEle = jQuerymin(event.currentTarget);
                        targetEle.css("background-image", "url(../image/boxy/del_hover_right.gif)");
                        jQuerymin("div", targetEle).css("background-image", "url(../image/boxy/del_hover_left.gif)");
                        jQuerymin("span", targetEle).css("background-image", "url(../image/boxy/del_hover_center.gif)");
                    }, function (event) {
                        var targetEle = jQuerymin(event.currentTarget);
                        targetEle.css("background-image", "url(../image/boxy/del_normal_right.gif)");
                        jQuerymin("div", targetEle).css("background-image", "url(../image/boxy/del_normal_left.gif)");
                        jQuerymin("span", targetEle).css("background-image", "url(../image/boxy/del_normal_center.gif)");
                    });
                }
            }
        };

        //更新Checked状态
        function UpdateIndCheckedStatus() {
            //清空所有checkbox的checked状态
            jQuerymin("input:checkbox", body).attr("checked", "");
            //清空所有checkbox的checkstyle样式
            jQuerymin("a", body).removeClass("checkedStyle");

            //循环选定的行业集合，为其设置checked状态，及背景样式
            for (var i = 0; i < arrSelItems.length; i++) {
                var element = jQuerymin("#indItem" + arrSelItems[i].classId, body);
                //设置选中项的背景样式
                element.addClass("checkedStyle");
                //根据选中的行业设置checkbox状态
                jQuerymin(":checkbox", element).attr("checked", "checked");
            }
        };

        //从选择结果集合中移除指定项
        function DelIndSelItem(event) {

            var element = jQuerymin(event.currentTarget);

            var indId = jQuerymin("span", element).attr("id").split("Sel")[1];
            var Items = new Array();

            for (var i = 0; i < arrSelItems.length; i++) {
                if (arrSelItems[i].classId != indId) {
                    Items.push(new Class(arrSelItems[i].classId, arrSelItems[i].className));
                }
            }
            arrSelItems = Items;
        };

        //点击选择或取消行业类别
        jQuerymin("a", body).click(function (event) {
            var id = jQuerymin(event.currentTarget).attr("id").split("Item")[1];

            var isContain = false;
            var children = new Array();
            //更新选择结果集合，存在则移除，否则添加
            for (var i = 0; i < arrSelItems.length; i++) {
                if (arrSelItems[i].classId != id) {
                    children.push(new Class(arrSelItems[i].classId, arrSelItems[i].className));
                } else { isContain = true; }
            }
            if (isContain) {
                //移除已选择项
                arrSelItems = children;
            } else {
                if (arrSelItems.length < maxSelectedCount) {
                    //添加新的选择项
                    arrSelItems.push(new Class(id, jQuerymin("#indTd" + id, body).text()));
                } else {
                    Boxy.alert("最多只能选择5项，若需要更换其它选项，请先点击取消部分选择结果。", null, { title: "提示信息" });
                }
            }
            //更新选择结果集合
            UpdateIndSelItems();
            //更新被选项状态
            UpdateIndCheckedStatus();
        }).css("min-width", 187);

      //提交事件
        jQuerymin("#ind-submit", foot).click(function () {

            var value = 0;
            var name = "";
            for (var i = 0; i < arrSelItems.length; i++) {
                if (value == 0) {
                    value = arrSelItems[i].classId;
                    name = arrSelItems[i].className;
                } else {
                    value += "," + arrSelItems[i].classId;
                    name += "," + arrSelItems[i].className;
                }
            }
            //返回选择结果
            var clicked = this;
            Boxy.get(this).hide(function () {
                if (callback) callback(value,name);
            });
        });

        //关闭选择器
        jQuerymin("#ind-cancel", foot).click(function (event) {

            Boxy.get(this).hide();
        });

        //css设置hover样式在IE没什么效果，所以用程序设置
        var linkStyle = jQuerymin("a", body);
        linkStyle.hover(function (event) {
            jQuerymin(event.currentTarget).addClass("hoverStyle");
        }, function (event) {
            jQuerymin(event.currentTarget).removeClass("hoverStyle");
        });

       selecter =  new Boxy(industry, options);

        //设置行业选择器样式
        SetIndustryStyle();
    },

    // 工作地区选择器
    // values 表示选定的地区编号，字符创类型，编号间以逗号分隔，省份编号前需要带p，城市编号前带c，地区编号前带d，如：p1,c2,d3，表示编号为1的省，编号为2的市，编号为3的区被选定
    // showns 表示默认展示区域编号，构成如下" a[,b] " ，其中a表示选定显示直接下属的省份，b表示选定显示直接下属的城市。
    // showns 值可以为空，可以单独设置默认展示下属的省份，但设置默认显示下属城市必需先设置对应的默认展示省份
    // callback 表示回调
    // option 为json格式的可选项的集合
    area: function (values, showns, callback, options) {

        options = jQuerymin.extend({ modal: true, closeable: true, fixed: false },
                                options || {},
                                { show: true, unloadOnHide: true });

        //最大选择项数
        var maxAreaSelectedCount = 5;
        //省份选择结果集合
        var arrProSelItems = new Array();
        //城市选择结果集合
        var arrCitySelItems = new Array();
        //城市下属区域选择结果集合
        var arrDisSelItems = new Array();
        //被选定显示下属的省份和城市
        var onShowPro = 1;
        var onShowCity = "";

        var area = jQuerymin('<div></div>').append('<div id="area-main"></div>').css("padding-bottom", "0");
        //获取工作地区主体句柄
        var main = jQuerymin("#area-main", area);
        //工作地区主体的head/body/foot三部分
        var head = jQuerymin("<div id='area-head' style='margin-bottom:5px;display:none;'></div>").html("<div class='area-title' style='font-weight:bold;height:16px;line-height:16px;'>你的选择结果</div><ul id='area-result'></ul>");
        var body = jQuerymin("<div id='area-body'></div>");
        var foot = jQuerymin("<div id='area-foot'><span id='area-msg'>注：最多只能选择五个职位类别</span><span id='area-cancel' >取消</span><span id='area-submit'>确定</span></div>");
        //省份块
        var province = jQuerymin("<div id='pro-main'><div id='pro-text'><span>地区:</span></div><div id='pro-content'></div></div>");
        var proContent = jQuerymin("#pro-content", province);
        //城市块
        var city = jQuerymin("<div class='city-main'><div id='city-text'>城市:<span></span>下属</div><div id='city-content'></div></div>");
        var cityContent = jQuerymin("#city-content", city);
        //工作地区主体内容附加
        body.append(city).append(province);
        main.append(head).append(body).append(foot);

        InitProContent();
        //初始化省份选项
        function InitProContent() {
            var proItems = GetProvinceItems();
            proContent.append(proItems);
            //添加省份选择项触发事件
            jQuerymin("a", proContent).click(function (event) {
                ProvinceClickListener(event);
            });
        };

        //设置省份项
        function GetProvinceItems() {
            var items = "";
            //将所有省份项添加到页面
            for (var i = 0; i < arrpro.length; i++) {
                items += ProvinceOption(arrpro[i].classId, arrpro[i].className);
            }
            return items;
        };

        //获取每个省份项的Html格式
        function ProvinceOption(id, name) {
            var value = "<a id='proItem" + id + "' href='javascript:void(0);'><input type='checkbox'/><span style='padding-left: 5px;' id='proName" + id + "'>" + name + "</span></a>";
            return value;
        };

        //省份项点击事件
        function ProvinceClickListener(event) {
            //获取省份ID
            var proId = $(event.currentTarget).attr("id").split("Item")[1];
            //判断是否点击已显示该省份下属，若未显示，则切换显示其下属城市
            if (city.attr("id").split("Id")[1] != proId) {
                onShowPro = proId;
                onShowCity = "";
                //更新显示省份下属城市或城市下属区域
                UpdateAreaSelectorShowStatus();
            }
            //判断点击的是否CheckBox，若为CheckBox则添加或取消选择省份
            if ($(event.target).attr("type") && ($(event.target).attr("type") == "checkbox")) {
                var isContain = false;
                var proList = new Array();
                //更新选择结果集合，存在则移除，否则添加
                for (var i = 0; i < arrProSelItems.length; i++) {
                    if (arrProSelItems[i].classId != proId) {
                        proList.push(arrProSelItems[i]);
                    } else { isContain = true; }
                }
                if (isContain) {
                    //移除已选择项
                    arrProSelItems = proList;
                } else {
                    //若地区集合和城市集合存在该省份的子项，则将其移除
                    var cityList = new Array();
                    var disList = new Array();
                    //循环城市集合
                    for (var i = 0; i < arrCitySelItems.length; i++) {
                        if (arrCitySelItems[i].classId != proId) {
                            cityList.push(arrCitySelItems[i]);
                        }
                    }
                    arrCitySelItems = cityList;
                    //循环地区集合
                    for (var i = 0; i < arrDisSelItems.length; i++) {
                        if (arrDisSelItems[i].classId != proId) {
                            disList.push(arrDisSelItems[i]);
                        }
                    }
                    arrDisSelItems = disList;

                    if (arrProSelItems.length + arrCitySelItems.length + arrDisSelItems.length < maxAreaSelectedCount) {
                        //添加新的选择项
                        arrProSelItems.push(new Class(proId, $("#proName" + proId).text()));
                    } else {
                        Boxy.alert("最多只能选择5项，若需要更换其它选项，请先点击取消部分选择结果。", null, { title: "提示信息" });
                    }
                }
                //更新显示选择结果集合
                UpdateAreaSelectorSelItems();
            }
            //更新被选中项的CheckBox状态
            UpdateAreaSelectorCheckedStatus();
        };

        //设置城市层内容
        SetCities();
        //设置城市层内容
        function SetCities() {
            var proId = onShowPro;
            city.attr("id", "proId" + proId);
            jQuerymin("#city-text>span", city).text(jQuerymin("#proName" + proId, proContent).text());
            var cityItems = ""; var isSub; var hasSub;
            //将所有城市项添加到页面
            for (var i = 0; i < arrcity.length; i++) {
                if (arrcity[i].classId == proId) {
                    isSub = false;
                    hasSub = false;
                    for (var j = 0; j < subDis.length; j++) {
                        //判断是否为城市项
                        if (arrcity[i].itemId == subDis[j].itemId) {
                            hasSub = true;
                            break;
                        }
                    }
                    cityItems += (CityOption(arrcity[i].itemId, arrcity[i].itemName, hasSub));
                }
            }
            cityContent.append(cityItems);
            //添加城市选择项触发事件
            jQuerymin("a", cityContent).click(function (event) {
                CityClickListener(event);
            });
        };

        //获取每个城市项的Html格式
        function CityOption(id, name, hasSub) {
            var value;
            if (hasSub) {
                value = "<a id='cityItem" + id + "' href='javascript:void(0);' class='hasSub'><input type='checkbox'/><span style='padding-left: 5px;' id='cityName" + id + "'>" + name + "</span></a>";
            } else {
                value = "<a id='cityItem" + id + "' href='javascript:void(0);'><input type='checkbox'/><span style='padding-left: 5px;' id='cityName" + id + "'>" + name + "</span></a>";
            }
            return value;
        };

        //触发点击城市选项事件
        function CityClickListener(event) {
            var curEle = jQuerymin(event.currentTarget);
            var curEleClass = curEle.attr("class");
            var element = jQuerymin(event.target);
            var eleType = element.attr("type");
            var cityId = curEle.attr("id").split("Item")[1];
            //清空显示下属地区的城市
            onShowCity = "";

            //点击包含下属地区城市，则显示下属地区

            if (curEleClass && curEleClass.indexOf("hasSub") != -1) {
                onShowCity = cityId;
            }
            //更新显示省份下属城市或城市下属区域
            UpdateAreaSelectorShowStatus();

            //判断该城市归属的省份是否被选中
            var isParentSelected = false;
            for (var i = 0; i < arrProSelItems.length; i++) {
                if (arrProSelItems[i].classId == onShowPro) {
                    isParentSelected = true;
                    break;
                }
            }

            if (!isParentSelected) {
                //点击城市checkbox或点击没有包含下属地区的城市，则选定该城市
                if ((eleType && (eleType == "checkbox")) || !(curEleClass && (curEleClass.indexOf("hasSub") != -1))) {
                    var isContain = false;
                    var cityList = new Array();
                    //更新选择结果集合，存在则移除，否则添加
                    for (var i = 0; i < arrCitySelItems.length; i++) {
                        if (arrCitySelItems[i].itemId != cityId) {
                            cityList.push(arrCitySelItems[i]);
                        } else { isContain = true; }
                    }
                    if (isContain) {
                        //移除已选择项
                        arrCitySelItems = cityList;
                    } else {
                        //若地区集合存在该城市的子项，则将其移除
                        var disList = new Array();
                        for (var i = 0; i < arrDisSelItems.length; i++) {
                            if (arrDisSelItems[i].itemId != cityId) {
                                disList.push(arrDisSelItems[i]);
                            }
                        }
                        arrDisSelItems = disList;

                        if (arrProSelItems.length + arrCitySelItems.length + arrDisSelItems.length < maxAreaSelectedCount) {
                            //添加新的选择项
                            arrCitySelItems.push(new Item(cityId, jQuerymin("#cityName" + cityId, curEle).text(), city.attr("id").split("Id")[1]));
                        } else {
                            Boxy.alert("最多只能选择5项，若需要更换其它选项，请先点击取消部分选择结果。", null, { title: "提示信息" });
                        }
                    }
                    //更新显示选择结果集合
                    UpdateAreaSelectorSelItems();
                }
            } //更新被选中项的CheckBox状态
            UpdateAreaSelectorCheckedStatus();
        };


        //设置城市下属区域集合
        function SetDistricts() {

            //城市下属区域层
            var disLayer = jQuerymin(".dis-content", cityContent);

            if ((onShowCity != "") && (disLayer.attr("id") != "cityId" + onShowCity)) {
                disLayer.attr("id", "cityId" + onShowCity);
                var disItems = "";
                for (var i = 0; i < subDis.length; i++) {
                    if (subDis[i].itemId == onShowCity) {
                        disItems += DistrictOption(subDis[i].subId, subDis[i].subName);
                    }
                }
                disLayer.append(disItems);

                jQuerymin("a", disLayer).click(function (event) {
                    DisClickListener(event);
                });
            }
        };

        //获取城市下属每个区域项的Html格式
        function DistrictOption(id, name) {
            var value = "<a id='disItem" + id + "' href='javascript:void(0);'><input type='checkbox'/><span style='padding-left: 5px;' id='disName" + id + "'>" + name + "</span></a>";
            return value;
        };

        //点击触发城市下属区域事件
        function DisClickListener(event) {
            var disId = jQuerymin(event.currentTarget).attr("id").split("Item")[1];
            //判断该地区归属的城市是否被选中
            var isParentSelected = false;
            for (var i = 0; i < arrCitySelItems.length; i++) {
                if (arrCitySelItems[i].itemId == onShowCity) {
                    isParentSelected = true;
                    break;
                }
            }

            if (!isParentSelected) {
                var isContain = false;
                var disList = new Array();
                //更新选择结果集合，存在则移除，否则添加
                for (var i = 0; i < arrDisSelItems.length; i++) {
                    if (arrDisSelItems[i].subId != disId) {
                        disList.push(arrDisSelItems[i]);
                    } else { isContain = true; }
                }
                if (isContain) {
                    //移除已选择项
                    arrDisSelItems = disList;
                } else {
                    if (arrProSelItems.length + arrCitySelItems.length + arrDisSelItems.length < maxAreaSelectedCount) {
                        //添加新的选择项
                        arrDisSelItems.push(new Sub(disId, $("#disName" + disId, cityContent).text(), onShowCity, onShowPro));
                    } else {
                        Boxy.alert("最多只能选择5项，若需要更换其它选项，请先点击取消部分选择结果。", null, { title: "提示信息" });
                    }
                }
                //更新显示选择结果集合
                UpdateAreaSelectorSelItems();
                //更新被选中项的CheckBox状态
                UpdateAreaSelectorCheckedStatus();
            }
        };

        //设置城市下属区域集合所在层
        function SetDisLayer() {

            var shouldCreate = false;
            //选定城市下属区域所在层
            var disLayer = jQuerymin(".dis-content", cityContent);
            //获取事件触发元素及其外部高度
            var curEle = jQuerymin("#cityItem" + onShowCity, cityContent);
            var eleHeight = curEle.outerHeight(true);
            var eleRelOffsetTop = curEle.offset().top - curEle.parent().offset().top;

            if (disLayer.attr("class") != null) {
                //获取相对父元素的上下偏移
                var layerRelOffsetTop = disLayer.offset().top - disLayer.parent().offset().top;
                //判断城市下属区域所在层是否在期望区域(点选的城市项的下一行)
                if ((curEle.offset().top < disLayer.offset().top) && (disLayer.offset().top < (curEle.offset().top + eleHeight * 2))) {
                    //点击同一行但不同城市时，清空下属区域层中的所有内容
                    if (disLayer.attr("id").split("Id")[1] != onShowCity) {
                        disLayer.empty();
                    }
                } else {
                    disLayer.remove();
                    shouldCreate = true;
                }
            } else {
                shouldCreate = true;
            }
            //创建并插入层
            if (shouldCreate) {
                //城市集合层内部宽度
                var contentWidth = cityContent.innerWidth();
                //城市项的外部宽度
                var itemWidth = jQuerymin("a:first", cityContent).outerWidth(true);
                //设定城市下属区域层插入的垂直位置
                var times = parseInt(eleRelOffsetTop / eleHeight) + 1;
                //获取待插入层的前一个同辈元素序号
                var index = parseInt(contentWidth / itemWidth) * times - 1;
                //获取城市ID
                var cityId = curEle.attr("id").split("Item")[1];

                var layerContent = "<div class='dis-content'></div>";
                //在指定元素后插入层
                jQuerymin("a:eq(" + index + ")", cityContent).after(layerContent);
            }
        }

        //更新显示省份下属城市或城市下属区域
        function UpdateAreaSelectorSelItems(isInit) {
            var element = jQuerymin("#area-result", head);
            //清空DOM中的选择结果
            element.empty();
            //若不存在选择结果，则隐藏选择结果部分
            if (arrProSelItems.length + arrCitySelItems.length + arrDisSelItems.length == 0) {
                head.slideUp(400);
            }
            else {
                if (isInit) {
                    head.show();
                }
                else {
                    head.slideDown(400);
                }
                var items = "";
                //循环添加省/市/区被选择项
                for (var i = 0; i < arrProSelItems.length; i++) {
                    items += "<li class='jobResultItem'><div class='result-pad-left'></div><span id='proSel" + arrProSelItems[i].classId + "' >" + arrProSelItems[i].className + "</span></li>";
                }
                for (var i = 0; i < arrCitySelItems.length; i++) {
                    items += "<li class='jobResultItem'><div class='result-pad-left'></div><span id='citySel" + arrCitySelItems[i].itemId + "' >" + arrCitySelItems[i].itemName + "</span></li>";
                }
                for (var i = 0; i < arrDisSelItems.length; i++) {
                    items += "<li class='jobResultItem'><div class='result-pad-left'></div><span id='disSel" + arrDisSelItems[i].subId + "' >" + arrDisSelItems[i].subName + "</span></li>";
                }

                if (items != "") {
                    element.append(items);

                    //为新添加项注册事件
                    jQuerymin(".jobResultItem", element).click(function (event) {
                        var ele = jQuerymin(event.target);

                        if (ele.attr("class") && ele.attr("class") == "jobResultItem") {
                            DelAreaSelItem(event);
                            UpdateAreaSelectorSelItems();
                            UpdateAreaSelectorCheckedStatus();
                        }
                    });

                    var resultEle = jQuerymin("li", element);
                    resultEle.hover(function (event) {
                        var targetEle = jQuerymin(event.currentTarget);
                        targetEle.css("background-image", "url(../image/boxy/del_hover_right.gif)");
                        jQuerymin("div", targetEle).css("background-image", "url(../image/boxy/del_hover_left.gif)");
                        jQuerymin("span", targetEle).css("background-image", "url(../image/boxy/del_hover_center.gif)");
                    }, function (event) {
                        var targetEle = jQuerymin(event.currentTarget);
                        targetEle.css("background-image", "url(../image/boxy/del_normal_right.gif)");
                        jQuerymin("div", targetEle).css("background-image", "url(../image/boxy/del_normal_left.gif)");
                        jQuerymin("span", targetEle).css("background-image", "url(../image/boxy/del_normal_center.gif)");
                    });
                }
            }
        };

        //从选择结果集合中移除指定项
        function DelAreaSelItem(event) {

            var ele = jQuerymin(event.currentTarget);

            var areaData = jQuerymin("span", ele).attr("id").split("Sel");
            var Items = new Array();

            switch (areaData[0]) {
                case "pro":
                    for (var i = 0; i < arrProSelItems.length; i++) {
                        if (arrProSelItems[i].classId != areaData[1]) {
                            Items.push(arrProSelItems[i]);
                        }
                    }
                    arrProSelItems = Items;
                    break;
                case "city":
                    for (var i = 0; i < arrCitySelItems.length; i++) {
                        if (arrCitySelItems[i].itemId != areaData[1]) {
                            Items.push(arrCitySelItems[i]);
                        }
                    }
                    arrCitySelItems = Items;
                    break;
                default:
                    for (var i = 0; i < arrDisSelItems.length; i++) {
                        if (arrDisSelItems[i].subId != areaData[1]) {
                            Items.push(arrDisSelItems[i]);
                        }
                    }
                    arrDisSelItems = Items;
                    break;
            }
        };

        //更新显示选择结果集合
        function UpdateAreaSelectorShowStatus() {
            var proId = city.attr("id").split("Id")[1];
            if (proId != onShowPro) {
                cityContent.empty();
                SetCities();
            }
            //选定城市下属区域所在层
            var disLayer = $(".dis-content", cityContent);
            //判断城市是需要显示下属区域
            if (onShowCity == "") {
                if (disLayer) {
                    //清空城市下属层
                    disLayer.remove();
                }
            } else {
                //设置城市下属层
                SetDisLayer();
                //设置城市下属项
                SetDistricts();
            }
        };

        //更新被选中项的CheckBox状态
        function UpdateAreaSelectorCheckedStatus() {
            //清空所有checkbox的checked状态
            jQuerymin("input:checkbox", body).attr({ "checked": "", "disabled": "" });
            //清空所有checkbox的checkstyle样式
            jQuerymin("a", body).removeClass("checkedStyle").removeClass("show-children");

            //循环选定的省份集合，为其设置checked状态，及背景样式
            for (var i = 0; i < arrProSelItems.length; i++) {
                var element = jQuerymin("#proItem" + arrProSelItems[i].classId, proContent);
                //设置选中项的背景样式
                element.addClass("checkedStyle");
                //根据选中的行业设置checkbox状态
                jQuerymin(":checkbox", element).attr("checked", "checked");
                if (arrProSelItems[i].classId == onShowPro) {
                    jQuerymin(":checkbox", cityContent).attr({ "checked": "checked", "disabled": "disabled" });
                }
            }

            //循环选定的城市集合，为其设置checked状态，及背景样式
            for (var i = 0; i < arrCitySelItems.length; i++) {

                var element = jQuerymin("#cityItem" + arrCitySelItems[i].itemId, cityContent);
                //设置选中项的背景样式
                element.addClass("checkedStyle");
                jQuerymin(":checkbox", element).attr("checked", "checked");
                //设置选中城市项对应的省份样式
                var proEle = jQuerymin("#proItem" + arrCitySelItems[i].classId, proContent);
                proEle.addClass("checkedStyle");
                //设置城市下属区域checkbox
                if (arrCitySelItems[i].itemId == onShowCity) {
                    jQuerymin(":checkbox", jQuerymin(".dis-content", cityContent)).attr({ "checked": "checked", "disabled": "disabled" });
                }
            }

            //设置显示城市下属区域项的样式
            jQuerymin("#cityItem" + onShowCity, cityContent).addClass("show-children");
            //循环选定的职位小类集合，为其设置checked状态，及背景样式
            for (var i = 0; i < arrDisSelItems.length; i++) {

                if (arrDisSelItems[i].itemId == onShowCity) {
                    var element = jQuerymin("#disItem" + arrDisSelItems[i].subId, cityContent);
                    //设置选中项的背景样式
                    jQuerymin(":checkbox", element).attr("checked", "checked");
                }
                //设置对应省份项的样式
                jQuerymin("#proItem" + arrDisSelItems[i].classId, proContent).addClass("checkedStyle");

                if (arrDisSelItems[i].classId == onShowPro) {
                    jQuerymin("#cityItem" + arrDisSelItems[i].itemId, cityContent).addClass("checkedStyle");
                }
            }
        };

        //提交事件
        jQuerymin("#area-submit", foot).click(function () {

            var value = 0;
            //获取省份集合字符串
            for (var i = 0; i < arrProSelItems.length; i++) {
                if (value == 0) {
                    value = "p" + parseInt(arrProSelItems[i].classId);
                } else {
                    value += ",p" + parseInt(arrProSelItems[i].classId);
                }
            }
            //获取城市集合字符串
            for (var i = 0; i < arrCitySelItems.length; i++) {
                if (value == 0) {
                    value = "c" + arrCitySelItems[i].itemId;
                } else {
                    value += ",c" + arrCitySelItems[i].itemId;
                }
            }
            //获取城市下属区域集合字符串
            for (var i = 0; i < arrDisSelItems.length; i++) {
                if (value == 0) {
                    value = "d" + arrDisSelItems[i].subId;
                } else {
                    value += ",d" + arrDisSelItems[i].subId;
                }
            }
            //返回选择结果
            var clicked = this;
            Boxy.get(this).hide(function () {
                if (callback) callback(value);
            });
        });

        //关闭选择器
        jQuerymin("#area-cancel", foot).click(function (event) {
            //隐藏工作地区选择器
            Boxy.get(this).hide();
        });


        //初始化工作地区信息
        function InitData() {

            //设置默认显示地区
            var showIds = showns + ",";
            if (showIds != ",") {
                var showItems = showIds.split(",");
                switch (showItems.length) {
                    case 3:
                        onShowPro = showItems[0];
                        onShowCity = showItems[1];
                        break;
                    case 2:
                        onShowPro = showItems[0];
                        onShowCity = "";
                        break;
                    default:
                        break;
                }
            }
            //设置选定地区
            var ids = values + ",";
            if (ids != ",") {
                var items = ids.split(",");

                //省份选择结果集合
                arrProSelItems = new Array();
                //城市选择结果集合
                arrCitySelItems = new Array();
                //城市下属区域选择结果集合
                arrDisSelItems = new Array();

                var type; var id;
                for (var i = 0; i < items.length - 1; i++) {
                    type = items[i].substr(0, 1);
                    id = items[i].substr(1);
                    switch (type) {
                        case "p":
                            for (var j = 0; j < arrpro.length; j++) {
                                if (arrpro[j].classId == id) {
                                    arrProSelItems.push(arrpro[j]);
                                    break;
                                }
                            }
                            break;
                        case "c":
                            for (var j = 0; j < arrcity.length; j++) {
                                if (arrcity[j].itemId == id) {
                                    arrCitySelItems.push(arrcity[j]);
                                    break;
                                }
                            }
                            break;
                        case "d":
                            for (var j = 0; j < subDis.length; j++) {
                                if (subDis[j].subId == id) {
                                    arrDisSelItems.push(subDis[j]);
                                    break;
                                }
                            }
                            break;
                            Default:
                            break;
                    }
                }
            }
            var isInit = true;
            UpdateAreaSelectorShowStatus();
            //更新选择结果集合
            UpdateAreaSelectorSelItems(isInit);
            //更新被选项状态
            UpdateAreaSelectorCheckedStatus();
        };

        //设置工作地区选择器样式
        function SetAreaStyle() {
            var title_bar = jQuerymin(".title-bar", area.parent());
            title_bar.css({ "background-color": "#1E90FF", "padding": 8 });
            jQuerymin(".close", title_bar).css({ right: 8, top: 7 });
        };

        //css设置hover样式在IE没什么效果，所以用程序设置
        var linkStyle = jQuerymin("a", body);
        linkStyle.hover(function (event) {
            jQuerymin(event.currentTarget).addClass("hoverStyle");
        }, function (event) {
            jQuerymin(event.currentTarget).removeClass("hoverStyle");
        });

        new Boxy(area, options);

        //设置工作地区选择器样式
        SetAreaStyle();
        //初始化工作地区信息
        InitData();
    },

    // 职位类型选择器
    // value 表示选定的职位类型编号，字符创类型，编号间以逗号分隔
    // shown 需要展示项的编号
    // callback 表示回调
    // option 为json格式的可选项的集合
    job: function (value, shown, callback, options) {
    	if(selecter && selecter.isVisible()){
    		return;    		
    	}
        options = jQuerymin.extend({ modal: false, closeable: true, fixed: false },
                                options || {},
                                { show: true, unloadOnHide: true });

        //最大选择项数
        var maxSelectedCount = 5;
        //选择项父项和子项的集合
        var arrClassSelectedParents = new Array();
        var arrClassSelectedChildren = new Array();
        
        //当前展示职位大类    
        var onShownParent = 24;

        var job = jQuerymin('<div></div>').append('<div id="job-main"></div>').css("padding-bottom", "0");

        //获取工作地区主体句柄
        var main = jQuerymin("#job-main", job);

        var head = jQuerymin("<div id='job-head' style='margin-bottom:5px;display:none;'></div>").html("<div class='head-title' style='font-weight:bold;height:16px;line-height:16px;'>你的选择结果</div><ul id='job-result'></ul>");

        var body = jQuerymin("<div id='job-body'></div>");

        var foot = jQuerymin("<div id='job-foot'><span id='job-msg'></span><span id='job-cancel' >取消</span><span id='job-submit'>确定</span></div>");

        body.append(GetParentItems());
        main.append(head).append(body).append(foot);

        //获取职位大类集合
        function GetParentItems() {
            var items = "";
            for (var i = 0; i < arrGrade.length; i++) {
                items += ParentOption(arrGrade[i].classId, arrGrade[i].className);
            };
            return items;
        };

        //获取每个父项的Html格式
        function ParentOption(id, name) {
            var value = "<a id='parItem" + id + "' href='javascript:void(0);' class='parentItem'><input type='checkbox' /><span id='parTd" + id + "' style='padding-left:2px;'>" + name + "</span></a>";
            return value;
        };

        //初始化选定职位
        function InitSelData() {
            //设置默认显示职位大类
            var showId = shown + ",";
            if (showId != ",") {
                onShownParent = parseInt(shown);
            }

            var items = (value + ",").split(",");

            arrClassSelectedParents = new Array();
            arrClassSelectedChildren = new Array();

            for (var i = 0; i < items.length - 1; i++) {
                var type = items[i].substr(0, 1);
                var id = items[i].substr(1);
                if (type == "g") {
                    for (var j = 0; j < arrGrade.length; j++) {
                        if (parseInt(id) == arrGrade[j].classId) {
                            //添加父类项
                            arrClassSelectedParents.push(arrGrade[j]);
                        }
                    }
                } else if (type == "c") {
                    for (var j = 0; j < arrClass.length; j++) {
                        if (id == arrClass[j].itemId) {
                            //添加子类项
                            arrClassSelectedChildren.push(arrClass[j]);
                        }
                    }
                }
            }
        };


        //更新被选择项
        function UpdateJobSelItems(isInit) {

            var element = jQuerymin("#job-result", head);
            //清空DOM中的选择结果
            element.empty();
            //若不存在选择结果，则隐藏选择结果部分
            if (arrClassSelectedParents.length + arrClassSelectedChildren.length == 0) {
                head.slideUp(400);
            }
            else {
                if (isInit) {
                    head.show();
                }
                else {
                    head.slideDown(400);
                }
                var items = "";
                //循环添加父类和子类被选择项
                for (var i = 0; i < arrClassSelectedParents.length; i++) {
                    items += "<li class='jobResultItem'><div class='result-pad-left'></div><span id='parSel" + arrClassSelectedParents[i].classId + "' >" + arrClassSelectedParents[i].className + "</span></li>";
                }
                for (var i = 0; i < arrClassSelectedChildren.length; i++) {
                    items += "<li class='jobResultItem'><div class='result-pad-left'></div><span id='chlSel" + arrClassSelectedChildren[i].itemId + "' >" + arrClassSelectedChildren[i].itemName + "</span></li>";
                }

                if (items != "") {
                    element.append(items);

                    //为新添加项注册事件
                    jQuerymin(".jobResultItem", element).click(function (event) {
                        var ele = jQuerymin(event.target);

                        if (ele.attr("class") && ele.attr("class") == "jobResultItem") {
                            DelJobSelItem(event);
                            UpdateJobSelItems();
                            UpdateJobCheckedStatus();
                        }
                    });

                    var resultEle = jQuerymin("li", element);
                    resultEle.hover(function (event) {
                        var targetEle = jQuerymin(event.currentTarget);
                        targetEle.css("background-image", "url(../image/boxy/del_hover_right.gif)");
                        jQuerymin("div", targetEle).css("background-image", "url(../image/boxy/del_hover_left.gif)");
                        jQuerymin("span", targetEle).css("background-image", "url(../image/boxy/del_hover_center.gif)");
                    }, function (event) {
                        var targetEle = jQuerymin(event.currentTarget);
                        targetEle.css("background-image", "url(../image/boxy/del_normal_right.gif)");
                        jQuerymin("div", targetEle).css("background-image", "url(../image/boxy/del_normal_left.gif)");
                        jQuerymin("span", targetEle).css("background-image", "url(../image/boxy/del_normal_center.gif)");
                    });
                }
            }
        };

        //更新Checked状态
        function UpdateJobCheckedStatus() {
            //清空所有checkbox的checked状态
            jQuerymin("input:checkbox", body).attr({ "checked": "", "disabled": "" });
            //清空所有checkbox的checkstyle样式
            jQuerymin("a", body).removeClass("checkedStyle").removeClass("show-children");

            //循环选定的职位大类集合，为其设置checked状态，及背景样式
            for (var i = 0; i < arrClassSelectedParents.length; i++) {
                var element = jQuerymin("#parItem" + arrClassSelectedParents[i].classId, body);
                //设置选中项的背景样式
                element.addClass("checkedStyle");
                //根据选中的行业设置checkbox状态
                jQuerymin(":checkbox", element).attr("checked", "checked");
                if (arrClassSelectedParents[i].classId == onShownParent) {
                    jQuerymin("#parId" + arrClassSelectedParents[i].classId + " :checkbox", body).attr({ "checked": "checked", "disabled": "disabled" });
                }
            }

            if (onShownParent != "") {
                //循环选定的职位小类集合，为其设置checked状态，及背景样式
                for (var i = 0; i < arrClassSelectedChildren.length; i++) {

                    var element = jQuerymin("#parItem" + arrClassSelectedChildren[i].classId, body);
                    //设置选中项的背景样式
                    element.addClass("checkedStyle");

                    if (arrClassSelectedChildren[i].classId == onShownParent) {
                        jQuerymin(":checkbox", jQuerymin("#childItem" + arrClassSelectedChildren[i].itemId)).attr("checked", "checked");
                    }
                }

                jQuerymin("#parItem" + onShownParent, body).addClass("show-children");
            }
        };

        //从选择结果集合中移除指定项
        function DelJobSelItem(event) {

            var ele = jQuerymin(event.currentTarget);

            var jobData = jQuerymin("span", ele).attr("id").split("Sel");
            var Items = new Array();

            if (jobData[0] == "par") {
                for (var i = 0; i < arrClassSelectedParents.length; i++) {
                    if (arrClassSelectedParents[i].classId != jobData[1]) {
                        Items.push(arrClassSelectedParents[i]);
                    }
                }
                arrClassSelectedParents = Items;
            } else {
                for (var i = 0; i < arrClassSelectedChildren.length; i++) {
                    if (arrClassSelectedChildren[i].itemId != jobData[1]) {
                        Items.push(arrClassSelectedChildren[i]);
                    }
                }
                arrClassSelectedChildren = Items;
            }
        };

        //点击选择或取消行业类别
        jQuerymin("a.parentItem", body).click(function (event) {

            var id = jQuerymin(event.currentTarget).attr("id").split("Item")[1];
            var chkEle = jQuerymin(event.target);

            if (id != onShownParent) {
                //设置当前展示大类
                onShownParent = id;
                //设置城市下属区域集合所在层
                SetChildrenLayer();
                //设置城市下属区域集合
                SetChildItems();
            }

            if (chkEle.attr("type") && chkEle.attr("type") == "checkbox") {
                var isContain = false;
                var parent = new Array();
                //更新选择结果集合，存在则移除，否则添加
                for (var i = 0; i < arrClassSelectedParents.length; i++) {
                    if (arrClassSelectedParents[i].classId != id) {
                        parent.push(arrClassSelectedParents[i]);
                    } else { isContain = true; }
                }
                if (isContain) {
                    //移除已选择项
                    arrClassSelectedParents = parent;
                } else {

                    var children = new Array();
                    //若子类集合中存在父类项的子集，则将其移除
                    for (var i = 0; i < arrClassSelectedChildren.length; i++) {
                        if (arrClassSelectedChildren[i].classId != id) {
                            children.push(arrClassSelectedChildren[i]);
                        }
                    }
                    //更新子类集合
                    arrClassSelectedChildren = children;

                    if (arrClassSelectedParents.length + arrClassSelectedChildren.length < maxSelectedCount) {
                        //添加新的选择项
                        arrClassSelectedParents.push(new Class(id, jQuerymin("#parTd" + id, body).text()));
                    } else {
                        Boxy.alert("最多只能选择5项，若需要更换其它选项，请先点击取消部分选择结果。", null, { title: "提示信息" });
                    }
                }
                //更新选择结果集合
                UpdateJobSelItems();
            }
            //更新被选项状态
            UpdateJobCheckedStatus();
        }).css("min-width", 187);

        //设置城市下属区域集合所在层
        function SetChildrenLayer() {

            var shouldCreate = false;
            //选定城市下属区域所在层
            var childrenLayer = jQuerymin(".childrenLayer", body);
            //获取事件触发元素及其外部高度
            var curEle = jQuerymin("#parItem" + onShownParent, body);
            var eleHeight = curEle.outerHeight(true);
            var childrenlayerHeight = 0;

            if (childrenLayer.attr("class") != null) {
                //获取子层外部高度
                childrenlayerHeight = childrenLayer.outerHeight(true);
                //获取相对父元素的上下偏移
                var layerRelOffsetTop = childrenLayer.offset().top - childrenLayer.parent().offset().top;
                //判断职位小类所在层是否在期望区域(点选的职位大类项的下一行)
                if ((curEle.offset().top < childrenLayer.offset().top) && (childrenLayer.offset().top < (curEle.offset().top + eleHeight * 2))) {
                    //点击同一行但不同职位大类时，清空下属区域层中的所有内容
                    if (childrenLayer.attr("id").split("Id")[1] != onShownParent) {
                        childrenLayer.empty();
                    }
                } else {
                    childrenLayer.remove();
                    //清除样式，防止位置取值时发生错误
                    jQuerymin("a", body).removeClass("show-children");
                    shouldCreate = true;
                }
            } else {
                shouldCreate = true;
            }
            //创建并插入层
            if (shouldCreate) {
                //重新获取事件触发元素及其外部高度（防止子层被移除发生位置错误）
                curEle = jQuerymin("#parItem" + onShownParent, body);
                //职位大类集合层内部宽度
                var contentWidth = body.innerWidth();
                //职位大类项的外部宽度
                var itemWidth = jQuerymin("a.parentItem:first", body).outerWidth(true);
                //获取期望职位大类集合净高度(除去职位小类)
                var eleRelOffsetTop = curEle.offset().top - curEle.parent().offset().top;
                //设定职位小类层插入的垂直位置
                var times = parseInt(eleRelOffsetTop / eleHeight) + 1;
                //获取待插入层的前一个同辈元素序号
                var index = parseInt(contentWidth / itemWidth) * times - 1;

                var layerContent = "<div class='childrenLayer' ></div>";


                var count = jQuerymin("a.parentItem", body).length;
                if (count <= index + 1) {
                    jQuerymin("a.parentItem:last", body).after(layerContent);
                } else {
                    //在指定元素后插入层
                    jQuerymin("a.parentItem:eq(" + index + ")", body).after(layerContent);
                }
                //jQuerymin(".childrenLayer", body).slideDown(400);
            }
        };

        //设置城市下属区域集合
        function SetChildItems() {

            //职位小类层
            var childrenLayer = $(".childrenLayer", body);

            if ((onShownParent != "") && (childrenLayer.attr("id") != "parId" + onShownParent)) {
                childrenLayer.attr("id", "parId" + onShownParent);
                for (var i = 0; i < arrClass.length; i++) {
                    if (arrClass[i].classId == onShownParent) {
                        childrenLayer.append(childOption(arrClass[i].itemId, arrClass[i].itemName));
                    }
                }

                jQuerymin("a", childrenLayer).click(function (event) {
                    childrenClickListener(event);
                });
            }
        };

        //获取城市下属每个区域项的Html格式
        function childOption(id, name) {
            var value = "<a id='childItem" + id + "' href='javascript:void(0);' class='childItem'><input type='checkbox'/><span style='padding-left: 5px;' id='childTd" + id + "'>" + name + "</span></a>";
            return value;
        };

        //工作小类点击事件触发
        function childrenClickListener(event) {

            //获取父项ID
            var parentId = jQuerymin(event.currentTarget).parent().attr("id").split("Id")[1];
            var isParContained = false;
            //判断父项是否已经被选择
            for (var j = 0; j < arrClassSelectedParents.length; j++) {
                if (arrClassSelectedParents[j].classId == parentId) {
                    isParContained = true;
                    break;
                }
            }

            if (!isParContained) {
                var id = jQuerymin(event.currentTarget).attr("id").split("Item")[1];
                var isContain = false;
                var children = new Array();
                //更新选择结果集合，存在则移除，否则添加
                for (var i = 0; i < arrClassSelectedChildren.length; i++) {
                    if (arrClassSelectedChildren[i].itemId != id) {
                        children.push(arrClassSelectedChildren[i]);
                    } else { isContain = true; }
                }
                if (isContain) {
                    //移除已选择项
                    arrClassSelectedChildren = children;
                } else {
                    if (arrClassSelectedParents.length + arrClassSelectedChildren.length < maxSelectedCount) {
                        //添加新的选择项
                        arrClassSelectedChildren.push(new Item(id, jQuerymin("#childTd" + id, body).text(), onShownParent));
                    } else {
                        Boxy.alert("最多只能选择5项，若需要更换其它选项，请先点击取消部分选择结果。", null, { title: "提示信息" });
                    }
                }
                //更新选择结果集合
                UpdateJobSelItems();
                //更新被选项状态
                UpdateJobCheckedStatus();
            }
        };

        //提交事件
        jQuerymin("#job-submit", foot).click(function () {

            var value = 0;
            var names = "";
            //获取职位大类集合字符串
            for (var i = 0; i < arrClassSelectedParents.length; i++) {
                if (value == 0) {
                    value = "g" + arrClassSelectedParents[i].classId;
                    names = arrClassSelectedParents[i].className;
                } else {
                    value += ",g" + arrClassSelectedParents[i].classId;
                    names += ","+arrClassSelectedParents[i].className;
                }
            }
            //获取职位小类集合字符串
            for (var i = 0; i < arrClassSelectedChildren.length; i++) {
                if (value == 0) {
                    value = "c" + arrClassSelectedChildren[i].itemId;
                    names = arrClassSelectedChildren[i].itemName;
                } else {
                    value += ",c" + arrClassSelectedChildren[i].itemId;
                    names += ","+arrClassSelectedChildren[i].itemName;
                }
            }
            //返回选择结果
            var clicked = this;
            Boxy.get(this).hide(function () {
                if (callback) callback(value,names);
            });
        });

        //关闭选择器
        jQuerymin("#job-cancel", foot).click(function (event) {

            Boxy.get(this).hide();
        });

        //初始化职位小类层
        function InitChildrenLayer() {
            if (onShownParent != "") {
                //设置城市下属区域集合所在层
                SetChildrenLayer();
                //设置城市下属区域集合
                SetChildItems();
            }
        };

        //初始化职位选择器状态
        function InitJobSelectorStatus() {
            var isInit = true;
            //更新选择结果集合
            UpdateJobSelItems(isInit);
            //更新被选项状态
            UpdateJobCheckedStatus();
        };

        //设置工作地区选择器样式
        function SetJobStyle() {
            var title_bar = jQuerymin(".title-bar", job.parent());
            title_bar.css({ "background-color": "#1E90FF", "padding": 8 });
            jQuerymin(".close", title_bar).css({ right: 8, top: 7 });
        };

        //        //css设置hover样式在IE没什么效果，所以用程序设置
        //        var linkStyle = jQuerymin("a", body);
        //        linkStyle.hover(function (event) {
        //            jQuerymin(event.currentTarget).addClass("hoverStyle");
        //        }, function (event) {
        //            jQuerymin(event.currentTarget).removeClass("hoverStyle");
        //        });

        selecter = new Boxy(job, options);

        //设置工作地区选择器样式
        SetJobStyle();
        //初始化选定职位
        InitSelData();
        //初始化职位小类层
        InitChildrenLayer();
        //初始化职位选择器状态
        InitJobSelectorStatus();

    },

    // returns true if a modal boxy is visible, false otherwise
    isModalVisible: function () {
        return jQuerymin('.boxy-modal-blackout').length > 0;
    },

    _u: function () {
        for (var i = 0; i < arguments.length; i++)
            if (typeof arguments[i] != 'undefined') return false;
        return true;
    },

    _handleResize: function (evt) {
        var d = jQuerymin(document);
        jQuerymin('.boxy-modal-blackout').css('display', 'none').css({
            width: d.width(), height: d.height()
        }).css('display', 'block');
    },

    _handleDrag: function (evt) {
        var d;
        if (d = Boxy.dragging) {
            d[0].boxy.css({ left: evt.pageX - d[1], top: evt.pageY - d[2] });
        }
    },

    _nextZ: function () {
        return Boxy.zIndex++;
    },

    _viewport: function () {
        var d = document.documentElement, b = document.body, w = window;
        return jQuerymin.extend(
            jQuerymin.browser.msie ?
                { left: b.scrollLeft || d.scrollLeft, top: b.scrollTop || d.scrollTop} :
                { left: w.pageXOffset, top: w.pageYOffset },
            !Boxy._u(w.innerWidth) ?
                { width: w.innerWidth, height: w.innerHeight} :
                (!Boxy._u(d) && !Boxy._u(d.clientWidth) && d.clientWidth != 0 ?
                    { width: d.clientWidth, height: d.clientHeight} :
                    { width: b.clientWidth, height: b.clientHeight }));
    }

});

Boxy.prototype = {
    
    // Returns the size of this boxy instance without displaying it.
    // Do not use this method if boxy is already visible, use getSize() instead.
    estimateSize: function() {
        this.boxy.css({visibility: 'hidden', display: 'block'});
        var dims = this.getSize();
        this.boxy.css('display', 'none').css('visibility', 'visible');
        return dims;
    },
                
    // Returns the dimensions of the entire boxy dialog as [width,height]
    getSize: function() {
        return [this.boxy.width(), this.boxy.height()];
    },
    
    // Returns the dimensions of the content region as [width,height]
    getContentSize: function() {
        var c = this.getContent();
        return [c.width(), c.height()];
    },
    
    // Returns the position of this dialog as [x,y]
    getPosition: function() {
        var b = this.boxy[0];
        return [b.offsetLeft, b.offsetTop];
    },
    
    // Returns the center point of this dialog as [x,y]
    getCenter: function() {
        var p = this.getPosition();
        var s = this.getSize();
        return [Math.floor(p[0] + s[0] / 2), Math.floor(p[1] + s[1] / 2)];
    },
                
    // Returns a jQuerymin object wrapping the inner boxy region.
    // Not much reason to use this, you're probably more interested in getContent()
    getInner: function() {
        return jQuerymin('.boxy-inner', this.boxy);
    },
    
    // Returns a jQuerymin object wrapping the boxy content region.
    // This is the user-editable content area (i.e. excludes titlebar)
    getContent: function() {
        return jQuerymin('.boxy-content', this.boxy);
    },
    
    // Replace dialog content
    setContent: function(newContent) {
        newContent = jQuerymin(newContent).css({display: 'block'}).addClass('boxy-content');
        if (this.options.clone) newContent = newContent.clone(true);
        this.getContent().remove();
        this.getInner().append(newContent);
        this._setupDefaultBehaviours(newContent);
        this.options.behaviours.call(this, newContent);
        return this;
    },
    
    // Move this dialog to some position, funnily enough
    moveTo: function(x, y) {
        this.moveToX(x).moveToY(y);
        return this;
    },
    
    // Move this dialog (x-coord only)
    moveToX: function(x) {
        if (typeof x == 'number') this.boxy.css({left: x});
        else this.centerX();
        return this;
    },
    
    // Move this dialog (y-coord only)
    moveToY: function(y) {
        if (typeof y == 'number') this.boxy.css({top: y});
        else this.centerY();
        return this;
    },
    
    // Move this dialog so that it is centered at (x,y)
    centerAt: function(x, y) {
        var s = this[this.visible ? 'getSize' : 'estimateSize']();
        if (typeof x == 'number') this.moveToX(x - s[0] / 2);
        if (typeof y == 'number') this.moveToY(y - s[1] / 2);
        return this;
    },
    
    centerAtX: function(x) {
        return this.centerAt(x, null);
    },
    
    centerAtY: function(y) {
        return this.centerAt(null, y);
    },
    
    // Center this dialog in the viewport
    // axis is optional, can be 'x', 'y'.
    center: function(axis) {
        var v = Boxy._viewport();
        var o = this.options.fixed ? [0, 0] : [v.left, v.top];
        if (!axis || axis == 'x') this.centerAt(o[0] + v.width / 2, null);
        if (!axis || axis == 'y') this.centerAt(null, o[1] + v.height / 2);
        return this;
    },
    
    // Center this dialog in the viewport (x-coord only)
    centerX: function() {
        return this.center('x');
    },
    
    // Center this dialog in the viewport (y-coord only)
    centerY: function() {
        return this.center('y');
    },
    
    // Resize the content region to a specific size
    resize: function(width, height, after) {
        if (!this.visible) return;
        var bounds = this._getBoundsForResize(width, height);
        this.boxy.css({left: bounds[0], top: bounds[1]});
        this.getContent().css({width: bounds[2], height: bounds[3]});
        if (after) after(this);
        return this;
    },
    
    // Tween the content region to a specific size
    tween: function(width, height, after) {
        if (!this.visible) return;
        var bounds = this._getBoundsForResize(width, height);
        var self = this;
        this.boxy.stop().animate({left: bounds[0], top: bounds[1]});
        this.getContent().stop().animate({width: bounds[2], height: bounds[3]}, function() {
            if (after) after(self);
        });
        return this;
    },
    
    // Returns true if this dialog is visible, false otherwise
    isVisible: function() {
        return this.visible;    
    },
    
    // Make this boxy instance visible
    show: function() {
        if (this.visible) return;
        if (this.options.modal) {
            var self = this;
            if (!Boxy.resizeConfigured) {
                Boxy.resizeConfigured = true;
                jQuerymin(window).resize(function() { Boxy._handleResize(); });
            }
            this.modalBlackout = jQuerymin('<div class="boxy-modal-blackout"></div>')
                .css({zIndex: Boxy._nextZ(),
                      opacity: 0.5,
                      width: jQuerymin(document).width(),
                      height: jQuerymin(document).height()})
                .appendTo(document.body);
            this.toTop();
            if (this.options.closeable) {
                jQuerymin(document.body).bind('keypress.boxy', function(evt) {
                    var key = evt.which || evt.keyCode;
                    if (key == 27) {
                        self.hide();
                        jQuerymin(document.body).unbind('keypress.boxy');
                    }
                });
            }
        }
        this.boxy.stop().css({opacity: 1}).show();
        this.visible = true;
        this._fire('afterShow');
        return this;
    },
    
    // Hide this boxy instance
    hide: function(after) {
        if (!this.visible) return;
        var self = this;
        if (this.options.modal) {
            jQuerymin(document.body).unbind('keypress.boxy');
            this.modalBlackout.animate({opacity: 0}, function() {
                jQuerymin(this).remove();
            });
        }
        this.boxy.stop().animate({opacity: 0}, 300, function() {
            self.boxy.css({display: 'none'});
            self.visible = false;
            self._fire('afterHide');
            if (after) after(self);
            if (self.options.unloadOnHide) self.unload();
        });
        return this;
    },
    
    toggle: function() {
        this[this.visible ? 'hide' : 'show']();
        return this;
    },
    
    hideAndUnload: function(after) {
        this.options.unloadOnHide = true;
        this.hide(after);
        return this;
    },
    
    unload: function() {
        this._fire('beforeUnload');
        this.boxy.remove();
        if (this.options.actuator) {
            jQuerymin.data(this.options.actuator, 'active.boxy', false);
        }
    },
    
    // Move this dialog box above all other boxy instances
    toTop: function() {
        this.boxy.css({zIndex: Boxy._nextZ()});
        return this;
    },
    
    // Returns the title of this dialog
    getTitle: function() {
        return jQuerymin('> .title-bar h2', this.getInner()).html();
    },
    
    // Sets the title of this dialog
    setTitle: function(t) {
        jQuerymin('> .title-bar h2', this.getInner()).html(t);
        return this;
    },
    
    //
    // Don't touch these privates
    
    _getBoundsForResize: function(width, height) {
        var csize = this.getContentSize();
        var delta = [width - csize[0], height - csize[1]];
        var p = this.getPosition();
        return [Math.max(p[0] - delta[0] / 2, 0),
                Math.max(p[1] - delta[1] / 2, 0), width, height];
    },
    
    _setupTitleBar: function() {
        if (this.options.title) {
            var self = this;
            var tb = jQuerymin("<div class='title-bar'></div>").html("<h2>" + this.options.title + "</h2>");
            if (this.options.closeable) {
                tb.append(jQuerymin("<a href='#' class='close'></a>").html(this.options.closeText));
            }
            if (this.options.draggable) {
                tb[0].onselectstart = function() { return false; }
                tb[0].unselectable = 'on';
                tb[0].style.MozUserSelect = 'none';
                if (!Boxy.dragConfigured) {
                    jQuerymin(document).mousemove(Boxy._handleDrag);
                    Boxy.dragConfigured = true;
                }
                tb.mousedown(function(evt) {
                    self.toTop();
                    Boxy.dragging = [self, evt.pageX - self.boxy[0].offsetLeft, evt.pageY - self.boxy[0].offsetTop];
                    jQuerymin(this).addClass('dragging');
                }).mouseup(function() {
                    jQuerymin(this).removeClass('dragging');
                    Boxy.dragging = null;
                    self._fire('afterDrop');
                });
            }
            this.getInner().prepend(tb);
            this._setupDefaultBehaviours(tb);
        }
    },
    
    _setupDefaultBehaviours: function(root) {
        var self = this;
        if (this.options.clickToFront) {
            root.click(function() { self.toTop(); });
        }
        jQuerymin('.close', root).click(function() {
            self.hide();
            return false;
        }).mousedown(function(evt) { evt.stopPropagation(); });
    },
    
    _fire: function(event) {
        this.options[event].call(this);
    }
    
};
