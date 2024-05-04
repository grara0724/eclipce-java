package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {

	//入力フォームを表示
	@GetMapping("/contact")
	public String index() {
		return "contactForm";
	}

	//予約詳細画面の表示
	@PostMapping("/contact")
	public String contact(
			@RequestParam(name = "how2watch", defaultValue = "") String how2watch,
			@RequestParam(name = "teamList", defaultValue = "") Collection<?> teamList,
			@RequestParam(name = "detail", defaultValue = "") String detail,
			@RequestParam(name = "dueDate", defaultValue = "") LocalDate dueDate,
			@RequestParam(name = "yourName", defaultValue = "") String yourName,
			@RequestParam(name = "yourEmail", defaultValue = "") String yourEmail,
			Model model) {

		//エラーの判別とそれに応じたメッセージパラメータの作成
		List<String> errorMsgs = new ArrayList<String>();

		//エラーがあったかどうかで遷移先が変わるためエラーをカウントする
		Integer errorCnt = 0;
		if (how2watch.length() == 0) {
			errorMsgs.add("観戦方法は選択必須です");
			errorCnt += 1;
		}
		if (CollectionUtils.isEmpty(teamList)) {
			errorMsgs.add("推しチームは選択必須です");
			errorCnt += 1;
		}

		//dueDateがnullの場合、compareToでnullと比較出来ずエラーになる。
		//しかし、前半の条件を加えても後半の比較は行うはずなのにこの場合はエラーにならない理由がわからない。
		if (dueDate != null && dueDate.compareTo(LocalDate.now()) < 1) {
			errorMsgs.add("観戦希望日は翌日以降を選択してください");
			errorCnt += 1;
		}
		if (yourName.equals("")) {
			errorMsgs.add("名前は必須です");
			errorCnt += 1;
		}
		if (yourName.length() >= 20) {
			errorMsgs.add("名前は20字以内で入力してください");
			errorCnt += 1;
		}
		if (yourEmail.equals("")) {
			errorMsgs.add("メールアドレスは必須です");
			errorCnt += 1;
		}

		if (errorCnt == 0) {
			model.addAttribute("how2watch", how2watch);
			model.addAttribute("teamList", teamList);
			model.addAttribute("detail", detail);
			model.addAttribute("dueDate", dueDate);
			model.addAttribute("yourName", yourName);
			model.addAttribute("yourEmail", yourEmail);
			return "contactResult";

		} else {
			model.addAttribute("errorMsgs", errorMsgs);
			return "contactForm";
		}

	}

	//予約詳細画面のチーム詳細のリンクからチーム詳細を表示
	//パスパラメータで管理
	@GetMapping("/contact/{team}")
	public String team(
			@PathVariable("team") String team,
			Model model) {

		//どのチームのリンクか判別
		switch (team) {
		case "LFC":
			model.addAttribute("team", team);
			model.addAttribute("exp", "リヴァプールFCは、イングランド・リヴァプールをホームタウンとする、イングランド・プレミアリーグに加盟するプロサッカークラブ。愛称はレッズ。");
			break;

		case "ARS":
			model.addAttribute("team", team);
			model.addAttribute("exp",
					"アーセナル・フットボール・クラブは、イングランドの首都ロンドン北部をホームタウンとする、プレミアリーグに加盟するプロサッカークラブ。ガナーズの愛称で知られる。");
			break;

		case "MCI":
			model.addAttribute("team", team);
			model.addAttribute("exp", "マンチェスター・シティFCは、イングランド・マンチェスターに拠点を置くプロサッカークラブ。強い。");
			break;
		}
		return "teamInformation";
	}
}
