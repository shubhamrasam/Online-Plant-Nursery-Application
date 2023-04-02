export const brands = [
  "SEEDS (3)",
  "PLANTS (9)",
  "SEEDS (43)",
  "PLANTS Forever (19)",
  "ALGENIST (31)",
  "Alpha-H (24)",
  "Alterna (59)",
  "Alurx (27)",
  "AMELIORATE (54)",
  "Angela Caglia Skincare (6)",
  "Anna Sui (3)",
  "Anthony (1)",
  "APIVITA (13)",
  "Aquis (7)",
  "ARCONA (52)",
  "ARQUISTE (11)",
];

export let brands_function = () => {
  let data = brands
    .map((ele, i) => {
      return `
       <label >
       <input type="checkbox"  name="" >
       <span class="" aria-hidden="true">
        ${brands[i]}
       </span>
       </label>
       `;
    })
    .join("");
  return data;
};
