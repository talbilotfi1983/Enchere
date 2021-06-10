	var requestURL = "https://api-adresse.data.gouv.fr/search/?q=8%20avenue%20emile%20zola";
	var select = document.getElementById("selection");
	window.onload = function() {
		document.getElementById("adresse").addEventListener("input",
				autocompleteAdresse, false);
	};
	function displaySelection(response) {
		if (Object.keys(response.features).length > 0) {
			select.style.display = "block";
			select.removeChild(select.firstChild);
			var ul = document.createElement('ul');
			select.appendChild(ul);
			response.features.forEach(function(element) {
				var li = document.createElement('li');
				var ligneAdresse = document.createElement('span');
				var infosAdresse = document
						.createTextNode(element.properties.postcode + ' '
								+ element.properties.city);
				var adresse = element.properties.name;
				var words = adresse.split(' ');
				var addr = adresse.substr(words[0].length,
						element.properties.name.length);

				if (isNaN(words[0]) == true) {
					ligneAdresse.innerHTML = adresse;
				} else {
					ligneAdresse.innerHTML = addr;
				}

				li.onclick = function() {
					selectAdresse(element);
				};
				li.appendChild(ligneAdresse);
				li.appendChild(infosAdresse);
				ul.appendChild(li);
			});
		} else {
			select.style.display = "none";
		}
	}
	function autocompleteAdresse() {
		var inputValue = document.getElementById("adresse").value;
		if (inputValue) {
			fetch(setQuery(inputValue)).then(function(response) {
				response.json().then(function(data) {
					displaySelection(data);
					

				});
			});
		} else {
			select.style.display = "none";
		}
	};
	function selectAdresse(element) {
		document.getElementById("adresse").value = element.properties.name
				+ "\r\n" + element.properties.postcode + " "
				+ element.properties.city;
		select.style.display = "none";
		var adresse = element.properties.name;

		var words = adresse.split(' ');

		var addr = adresse.substr(words[0].length,
				element.properties.name.length);
		if (isNaN(words[0]) == true) {
			document.getElementById("adresse").value = adresse;
		} else {
			document.getElementById("adresse").value = addr;
		}

		document.getElementById("codePostal").value = element.properties.postcode;
		document.getElementById("ville").value = element.properties.city;
	}
	function setQuery(value) {
		return requestURL + value + "?type=housenumber&autocomplete=1";
	}