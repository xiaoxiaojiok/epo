/*
 * FCKeditor - The text editor for Internet - http://www.fckeditor.net
 * Copyright (C) 2003-2008 Frederico Caldeira Knabben
 *
 * == BEGIN LICENSE ==
 *
 * Licensed under the terms of any of the following licenses at your
 * choice:
 *
 *  - GNU General Public License Version 2 or later (the "GPL")
 *    http://www.gnu.org/licenses/gpl.html
 *
 *  - GNU Lesser General Public License Version 2.1 or later (the "LGPL")
 *    http://www.gnu.org/licenses/lgpl.html
 *
 *  - Mozilla Public License Version 1.1 or later (the "MPL")
 *    http://www.mozilla.org/MPL/MPL-1.1.html
 *
 * == END LICENSE ==
 *
 * Chinese Simplified language file.
 */

var FCKLang =
{
// Language direction : "ltr" (left to right) or "rtl" (right to left).
Dir					: "ltr",

// Toolbar Items and Context Menu
Preview				: "\u9884\u89c8",
Cut					: "\u526a\u5207",
Copy				: "\u590d\u5236",
Paste				: "\u7c98\u8d34",
PasteText			: "\u7c98\u8d34\u4e3a\u65e0\u683c\u5f0f\u6587\u672c",
PasteWord			: "\u4ece MS Word \u7c98\u8d34",
RemoveFormat		: "\u6e05\u9664\u683c\u5f0f",
InsertLinkLbl		: "\u8d85\u94fe\u63a5",
InsertLink			: "\u63d2\u5165/\u7f16\u8f91\u8d85\u94fe\u63a5",
RemoveLink			: "\u53d6\u6d88\u8d85\u94fe\u63a5",
Anchor				: "\u63d2\u5165/\u7f16\u8f91\u951a\u70b9\u94fe\u63a5",
AnchorDelete		: "\u6e05\u9664\u951a\u70b9\u94fe\u63a5",
InsertImageLbl		: "\u56fe\u8c61",
InsertImage			: "\u63d2\u5165/\u7f16\u8f91\u56fe\u8c61",
InsertFlashLbl		: "Flash",
InsertFlash			: "\u63d2\u5165/\u7f16\u8f91 Flash",
InsertLineLbl		: "\u6c34\u5e73\u7ebf",
InsertLine			: "\u63d2\u5165\u6c34\u5e73\u7ebf",
InsertSmileyLbl		: "\u8868\u60c5\u7b26",
InsertSmiley		: "\u63d2\u5165\u8868\u60c5\u56fe\u6807",
About				: "\u5173\u4e8e FCKeditor",
Bold				: "\u52a0\u7c97",
Italic				: "\u503e\u659c",
Underline			: "\u4e0b\u5212\u7ebf",
StrikeThrough		: "\u5220\u9664\u7ebf",
LeftJustify			: "\u5de6\u5bf9\u9f50",
CenterJustify		: "\u5c45\u4e2d\u5bf9\u9f50",
RightJustify		: "\u53f3\u5bf9\u9f50",
BlockJustify		: "\u4e24\u7aef\u5bf9\u9f50",
DecreaseIndent		: "\u51cf\u5c11\u7f29\u8fdb\u91cf",
IncreaseIndent		: "\u589e\u52a0\u7f29\u8fdb\u91cf",
Blockquote			: "\u5f15\u7528\u6587\u5b57",
Undo				: "\u64a4\u6d88",
Redo				: "\u91cd\u505a",
NumberedListLbl		: "\u7f16\u53f7\u5217\u8868",
NumberedList		: "\u63d2\u5165/\u5220\u9664\u7f16\u53f7\u5217\u8868",
BulletedListLbl		: "\u9879\u76ee\u5217\u8868",
BulletedList		: "\u63d2\u5165/\u5220\u9664\u9879\u76ee\u5217\u8868",
ShowDetails			: "\u663e\u793a\u8be6\u7ec6\u8d44\u6599",
Style				: "\u6837\u5f0f",
FontFormat			: "\u683c\u5f0f",
Font				: "\u5b57\u4f53",
FontSize			: "\u5927\u5c0f",
TextColor			: "\u6587\u672c\u989c\u8272",
BGColor				: "\u80cc\u666f\u989c\u8272",
Source				: "\u6e90\u4ee3\u7801",
InsertCodes			: "\u63d2\u5165\u4ee3\u7801",

FontFormats			: "\u666e\u901a;\u5df2\u7f16\u6392\u683c\u5f0f;\u5730\u5740;\u6807\u9898 1;\u6807\u9898 2;\u6807\u9898 3;\u6807\u9898 4;\u6807\u9898 5;\u6807\u9898 6;\u6bb5\u843d(DIV)",

// Alerts and Messages
ProcessingXHTML		: "\u6b63\u5728\u5904\u7406 XHTML\uff0c\u8bf7\u7a0d\u7b49...",
Done				: "\u5b8c\u6210",
PasteWordConfirm	: "\u60a8\u8981\u7c98\u8d34\u7684\u5185\u5bb9\u597d\u50cf\u662f\u6765\u81ea MS Word\uff0c\u662f\u5426\u8981\u6e05\u9664 MS Word \u683c\u5f0f\u540e\u518d\u7c98\u8d34\uff1f",
NotCompatiblePaste	: "\u8be5\u547d\u4ee4\u9700\u8981 Internet Explorer 5.5 \u6216\u66f4\u9ad8\u7248\u672c\u7684\u652f\u6301\uff0c\u662f\u5426\u6309\u5e38\u89c4\u7c98\u8d34\u8fdb\u884c\uff1f",
UnknownToolbarItem	: "\u672a\u77e5\u5de5\u5177\u680f\u9879\u76ee \"%1\"",
UnknownCommand		: "\u672a\u77e5\u547d\u4ee4\u540d\u79f0 \"%1\"",
NotImplemented		: "\u547d\u4ee4\u65e0\u6cd5\u6267\u884c",
UnknownToolbarSet	: "\u5de5\u5177\u680f\u8bbe\u7f6e \"%1\" \u4e0d\u5b58\u5728",
NoActiveX			: "\u6d4f\u89c8\u5668\u5b89\u5168\u8bbe\u7f6e\u9650\u5236\u4e86\u672c\u7f16\u8f91\u5668\u7684\u67d0\u4e9b\u529f\u80fd\u3002\u60a8\u5fc5\u987b\u542f\u7528\u5b89\u5168\u8bbe\u7f6e\u4e2d\u7684\u201c\u8fd0\u884c ActiveX \u63a7\u4ef6\u548c\u63d2\u4ef6\u201d\uff0c\u5426\u5219\u5c06\u51fa\u73b0\u67d0\u4e9b\u9519\u8bef\u5e76\u7f3a\u5c11\u529f\u80fd\u3002",
DialogBlocked		: "\u65e0\u6cd5\u6253\u5f00\u5bf9\u8bdd\u6846\u7a97\u53e3\uff0c\u8bf7\u786e\u8ba4\u662f\u5426\u542f\u7528\u4e86\u7981\u6b62\u5f39\u51fa\u7a97\u53e3\u6216\u7f51\u9875\u5bf9\u8bdd\u6846\uff08IE\uff09\u3002",

// Dialogs
DlgBtnOK			: "\u786e\u5b9a",
DlgBtnCancel		: "\u53d6\u6d88",
DlgBtnClose			: "\u5173\u95ed",
DlgAdvancedTag		: "\u9ad8\u7ea7",
DlgOpOther			: "<\u5176\u5b83>",
DlgInfoTab			: "\u4fe1\u606f",
DlgAlertUrl			: "\u8bf7\u63d2\u5165 URL",

// General Dialogs Labels
DlgGenNotSet		: "<\u6ca1\u6709\u8bbe\u7f6e>",

// Image Dialog
DlgImgTitle			: "\u56fe\u8c61\u5c5e\u6027",
DlgImgInfoTab		: "\u56fe\u8c61",
DlgImgURL			: "\u6e90\u6587\u4ef6",
DlgImgAlt			: "\u66ff\u6362\u6587\u672c",
DlgImgWidth			: "\u5bbd\u5ea6",
DlgImgHeight		: "\u9ad8\u5ea6",
DlgImgBorder		: "\u8fb9\u6846\u5927\u5c0f",
DlgImgHSpace		: "\u6c34\u5e73\u95f4\u8ddd",
DlgImgVSpace		: "\u5782\u76f4\u95f4\u8ddd",
DlgImgAlign			: "\u5bf9\u9f50\u65b9\u5f0f",
DlgImgAlignLeft		: "\u5de6\u5bf9\u9f50",
DlgImgAlignAbsBottom: "\u7edd\u5bf9\u5e95\u8fb9",
DlgImgAlignAbsMiddle: "\u7edd\u5bf9\u5c45\u4e2d",
DlgImgAlignBaseline	: "\u57fa\u7ebf",
DlgImgAlignBottom	: "\u5e95\u8fb9",
DlgImgAlignMiddle	: "\u5c45\u4e2d",
DlgImgAlignRight	: "\u53f3\u5bf9\u9f50",
DlgImgAlignTextTop	: "\u6587\u672c\u4e0a\u65b9",
DlgImgAlignTop		: "\u9876\u7aef",
DlgImgAlertUrl		: "\u8bf7\u8f93\u5165\u56fe\u8c61\u5730\u5740",

// Flash Dialog
DlgFlashTitle		: "Flash \u5c5e\u6027",
DlgFlashChkPlay		: "\u81ea\u52a8\u64ad\u653e",
DlgFlashChkLoop		: "\u5faa\u73af",
DlgFlashChkMenu		: "\u542f\u7528Flash\u83dc\u5355",
DlgFlashScale		: "\u7f29\u653e",
DlgFlashScaleAll	: "\u5168\u90e8\u663e\u793a",
DlgFlashScaleNoBorder	: "\u65e0\u8fb9\u6846",
DlgFlashScaleFit	: "\u4e25\u683c\u5339\u914d",

// Code Dialog
DlgCodesTitle		: "\u63d2\u5165\u4ee3\u7801",
DlgCodesLanguage	: "\u8bed\u8a00",
DlgCodesContent		: "\u5185\u5bb9",

// Link Dialog
DlgLnkWindowTitle	: "\u8d85\u94fe\u63a5",

DlgLnkTarget		: "\u76ee\u6807",
DlgLnkTargetBlank	: "\u65b0\u7a97\u53e3 (_blank)",
DlgLnkTargetParent	: "\u7236\u7a97\u53e3 (_parent)",
DlgLnkTargetSelf	: "\u672c\u7a97\u53e3 (_self)",
DlgLnkTargetTop		: "\u6574\u9875 (_top)",

DlnLnkMsgNoUrl		: "\u8bf7\u8f93\u5165\u8d85\u94fe\u63a5\u5730\u5740",
DlnLnkMsgNoEMail	: "\u8bf7\u8f93\u5165\u7535\u5b50\u90ae\u4ef6\u5730\u5740",
DlnLnkMsgNoAnchor	: "\u8bf7\u9009\u62e9\u4e00\u4e2a\u951a\u70b9",
DlnLnkMsgInvPopName	: "\u5f39\u51fa\u7a97\u53e3\u540d\u79f0\u5fc5\u987b\u4ee5\u5b57\u6bcd\u5f00\u5934\uff0c\u5e76\u4e14\u4e0d\u80fd\u542b\u6709\u7a7a\u683c\u3002",

// Color Dialog
DlgColorTitle		: "\u9009\u62e9\u989c\u8272",

// Smiley Dialog
DlgSmileyTitle		: "\u63d2\u5165\u8868\u60c5\u56fe\u6807",

// Paste Operations / Dialog
PasteErrorCut	: "\u60a8\u7684\u6d4f\u89c8\u5668\u5b89\u5168\u8bbe\u7f6e\u4e0d\u5141\u8bb8\u7f16\u8f91\u5668\u81ea\u52a8\u6267\u884c\u526a\u5207\u64cd\u4f5c\uff0c\u8bf7\u4f7f\u7528\u952e\u76d8\u5feb\u6377\u952e(Ctrl+X)\u6765\u5b8c\u6210\u3002",
PasteErrorCopy	: "\u60a8\u7684\u6d4f\u89c8\u5668\u5b89\u5168\u8bbe\u7f6e\u4e0d\u5141\u8bb8\u7f16\u8f91\u5668\u81ea\u52a8\u6267\u884c\u590d\u5236\u64cd\u4f5c\uff0c\u8bf7\u4f7f\u7528\u952e\u76d8\u5feb\u6377\u952e(Ctrl+C)\u6765\u5b8c\u6210\u3002",

PasteAsText		: "\u7c98\u8d34\u4e3a\u65e0\u683c\u5f0f\u6587\u672c",
PasteFromWord	: "\u4ece MS Word \u7c98\u8d34",

DlgPasteMsg2	: "\u8bf7\u4f7f\u7528\u952e\u76d8\u5feb\u6377\u952e(<STRONG>Ctrl+V</STRONG>)\u628a\u5185\u5bb9\u7c98\u8d34\u5230\u4e0b\u9762\u7684\u65b9\u6846\u91cc\uff0c\u518d\u6309 <STRONG>\u786e\u5b9a</STRONG>\u3002",
DlgPasteSec		: "\u56e0\u4e3a\u4f60\u7684\u6d4f\u89c8\u5668\u7684\u5b89\u5168\u8bbe\u7f6e\u539f\u56e0\uff0c\u672c\u7f16\u8f91\u5668\u4e0d\u80fd\u76f4\u63a5\u8bbf\u95ee\u4f60\u7684\u526a\u8d34\u677f\u5185\u5bb9\uff0c\u4f60\u9700\u8981\u5728\u672c\u7a97\u53e3\u91cd\u65b0\u7c98\u8d34\u4e00\u6b21\u3002",
DlgPasteIgnoreFont		: "\u5ffd\u7565 Font \u6807\u7b7e",
DlgPasteRemoveStyles	: "\u6e05\u7406 CSS \u6837\u5f0f",

// Color Picker
ColorAutomatic	: "\u81ea\u52a8",

// Anchor Dialog
DlgAnchorTitle		: "\u547d\u540d\u951a\u70b9",
DlgAnchorName		: "\u951a\u70b9\u540d\u79f0",
DlgAnchorErrorName	: "\u8bf7\u8f93\u5165\u951a\u70b9\u540d\u79f0",

// About Dialog
DlgAboutAboutTab	: "\u5173\u4e8e",
DlgAboutInfo		: "\u8981\u83b7\u5f97\u66f4\u591a\u4fe1\u606f\u8bf7\u8bbf\u95ee "

};
