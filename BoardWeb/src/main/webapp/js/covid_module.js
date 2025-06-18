/**
 *  covid_module.js
 */

const defaultNum = 10;
	let url = 'https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=WPTEj1EfDxrjOY5sMxf91b%2Fm2vfyYm2fTAGvyXZFcrdzD4XswHHldlgEMdDpAhyvRR2Sh1SLy7%2FjHPkedVgrjA%3D%3D';

function makeRow(center){

	let tr = document.createElement('tr');

	for(const prop of ['id', 'centerName','phoneNumber']){
		let td = document.createElement('td'); //<td></td>
		td.innerHTML = center[prop];  // center['id'] // <td>1</td>
		tr.appendChild(td)
	}
	return tr;
}

export {makeRow, url}