var chartDataStr = decodeHtml(chartData);
//convertim string-ul intr-un obiect javascript
var chartJsonArray = JSON.parse(chartDataStr);


var arrayLength = chartJsonArray.length;
var numericData = [];
var labelData = [];

//preluam datele din obiectul js
for(var i=0;i<arrayLength;i++){
	numericData[i] = chartJsonArray[i].value;
	labelData[i] = chartJsonArray[i].label;
}


  const labels = labelData;

  const data = {
    labels: labels,
    datasets: [{
      label: 'My First dataset',
      backgroundColor: ["#151414","#7D7B7B","#F2EDED"],
      data: numericData,
    }]
  };

  const config = {
    type: 'doughnut',
    data: data,
   	options: {
        plugins: {
            title: {
                display: true,
                text: 'Project Statuses'
            }
        }
    }
  };

const myChart = new Chart(
    document.getElementById('myPieChart'),
    config
  );
  
  //"[{"value": 1, "label": "COMPLETED"},{"value": 2, "label": "INPROGRESS"},{"value": 1, "label": "NOTSTARTED"}]"
  function decodeHtml(html){
	var txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}
  

