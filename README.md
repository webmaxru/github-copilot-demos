# Copilot Demos

Check out following settings for new features.

## chat.commandCenter.enabled

## github.copilot.chat.edits.enabled

## github.copilot.chat.reviewSelection.instructions

```json
 "github.copilot.chat.reviewSelection.instructions": [
  {
   "text": "Logging should be done with the Log4j ."
  },
  {
   "text": "Always use the Polly library for fault-handling."
  },
  {
   "file": "code-style.md" // import instructions from file `code-style.md`
  }
 ]
 // 
 // code style 
 // Private fields should start with an underscore.
 // A file can only contain one class declaration.
```

## github.copilot.chat.search.semanticTextResults

```text
Last milestone, we introduced the ability to perform a semantic search using GitHub Copilot to get search results that are semantically relevant to your query. We have now improved the search results by sorting them by their relevance. Keyword matches from more relevant snippets are deemed more relevant overall.
```

## github.copilot.chat.codeGeneration.useInstructionFiles

```text
.github/copilot-instructions.md

Use snake_case for variable and function names.
Use CamelCase for class names.
Follow PEP 8 style guidelines.
Include type hints for function parameters and return types.
Write docstrings for all public modules, classes, functions, and methods.

Use @terminal when answering questions about Git.

Answer all questions in the style of a friendly colleague, using informal language.
```

## chat.experimental.detectParticipant.enabled

## Copilot > Review and Comment
