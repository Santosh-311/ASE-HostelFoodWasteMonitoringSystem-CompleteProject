const BASE=import.meta.env.VITE_API_URL||'http://localhost:8080/api';
export function getToken(){return localStorage.getItem('fw_token')||''}
export async function api(path,options={}){const headers={'Content-Type':'application/json',...(options.headers||{})};if(getToken())headers.Authorization=`Bearer ${getToken()}`;const res=await fetch(BASE+path,{...options,headers});const t=await res.text();let d;try{d=t?JSON.parse(t):null}catch{d=t}if(!res.ok)throw new Error(d?.message||`Request failed (${res.status})`);return d}
