var getD = function(id) {
		return document.getElementById(id);
	};

	function show_menu(num) {
		for (var i = 0; i < 100; i++) {
			if (getD('f0' + i)) {
				getD('f0' + i).className = '';
			}
		}
		getD('f0' + num).className = 'left02down01_xia_li';//触发以后TAG样式
	}

	function show_menuB(numB) {
		for (var j = 0; j < 100; j++) {
			if (j != numB) {
				if (getD('Bli0' + j)) {
					getD('Bli0' + j).style.display = 'none';
					getD('Bf0' + j).style.background = 'url(/images/01.gif)';
				}
			}
		}
		if (getD('Bli0' + numB)) {
			if (getD('Bli0' + numB).style.display == 'block') {
				getD('Bli0' + numB).style.display = 'none';
				getD('Bf0' + numB).style.background = 'url(/images/01.gif)';
			} else {
				getD('Bli0' + numB).style.display = 'block';
				getD('Bf0' + numB).style.background = 'url(/images/02.gif)';
			}
		}
	}

	var temp = 0;
	function show_menuC() {
		if (temp == 0) {
			document.getElementById('LeftBox').style.display = 'none';
			document.getElementById('RightBox').style.marginLeft = '0';
			document.getElementById('Mobile').style.background = 'url(/images/center.gif)';

			temp = 1;
		} else {
			document.getElementById('RightBox').style.marginLeft = '222px';
			document.getElementById('LeftBox').style.display = 'block';
			document.getElementById('Mobile').style.background = 'url(/images/center0.gif)';

			temp = 0;
		}
	}
	
	function mbar(sobj, url) {
		
		var docurl =sobj.options[sobj.selectedIndex].value;
		if (docurl != "") {
			 document.getElementById("selectSv").action=url+"?serverId="+docurl;
			 document.getElementById("selectSv").submit();
		}
	}
	
	function splitPage(currentPage) {
		
		var url =document.getElementById("singlelog").action;
		document.getElementById("singlelog").action=url+"?currentPage="+currentPage;
		document.getElementById("singlelog").submit();
	}
	