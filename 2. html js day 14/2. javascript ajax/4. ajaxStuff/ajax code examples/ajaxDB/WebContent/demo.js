function load(id, url) {
	var ajaxObject = new XMLHttpRequest();
	ajaxObject.open("GET", url, true);
	ajaxObject.send(null);
	ajaxObject.onreadystatechange = function() {
		if (ajaxObject.readyState == 4 && ajaxObject.status == 200) {
			document.getElementById(id).innerHTML = ajaxObject.responseText;
		}
	};

}