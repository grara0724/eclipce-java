const autoCompleteJS = new autoComplete({
  placeHolder: "Search for Food...",
  data: {
    src: [
      "豚骨ラーメン",
      "醤油ラーメン",
      "味噌ラーメン",
      "塩ラーメン",
      "つけ麺",
      "博多ラーメン",
      "札幌ラーメン",
      "東京ラーメン",
      "熊本ラーメン",
      "鹿児島ラーメン",
      "担々麺",
      "冷やし中華",
      "Tonkotsu Ramen",
      "Shoyu Ramen",
      "Miso Ramen",
      "Shio Ramen",
      "Tsukemen",
      "Hakata Ramen",
      "Sapporo Ramen",
      "Tokyo Ramen",
      "Kumamoto Ramen",
      "Kagoshima Ramen",
      "Tantanmen",
      "Hiyashi Chuka"
    ],
    cache: true,
  },
  resultItem: {
    highlight: true
  },
  events: {
    input: {
      selection: (event) => {
        const selection = event.detail.selection.value;
        autoCompleteJS.input.value = selection;
      }
    }
  }
});